#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//char *line = NULL;
// getline(&line, &len, file)
// free(line);
ssize_t getline(char **lineptr, size_t *n, FILE *NOW_file) {// ssize t как size t но допускается только -1 чтобы вернуть и обозначить ошибку таким образом
    if (lineptr == NULL || n == NULL || NOW_file == NULL) {
        return -1;
    }
    size_t pos = 0;
    int c;
    // если буфер не выделен, выделяем его
    if (*lineptr == NULL) {
        *n = 128; // начальный размер
        *lineptr = (char *)malloc(*n);
        if (*lineptr == NULL) {
            return -1;
        }
    }
    while ((c = fgetc(NOW_file)) != EOF) { //fgetc читаем символы по одному
        // увеличиваем буфер, если он заполнен
        if (pos + 1 >= *n) {
            *n *= 2;
            char *new_ptr = (char *)realloc(*lineptr, *n);
            if (new_ptr == NULL) {
                return -1;
            }
            *lineptr = new_ptr;
        }
        //  символ в буфер
        (*lineptr)[pos++] = c;
        // прерываем чтение
        if (c == '\n') {
            break;
        }
    }
    // значит не прочитали
    if (pos == 0 && c == EOF) {
        return -1;
    }
    (*lineptr)[pos] = '\0'; 
    return pos;
}

void Encode(const char* F1, const char* F2, const char* output) {
    FILE *file1 = fopen(F1, "rb");// что шифруем
    FILE *file2 = fopen(F2, "r");// куда шифруем
    FILE *out = fopen(output, "w+"); // резулт
    
    if (!file2 || !file1 || !out) {
        printf("Error opening files\n");
        exit(1);
    }
    
    char *line = NULL;
    size_t len = 0;
    ssize_t read;
    int bit_count = 0;
    unsigned char byte = 0;
    
    // читаем байт из F1 а потом бьем его на 8 циклом
    int byte_read = fread(&byte, 1, 1, file1);
    while (byte_read == 1) {
        // бъем
        for (int i = 7; i >= 0; i--) {
            // читаем умной функцией
            if (read = getline(&line, &len, file2) == -1) {
                // если строки в ф2 закончились, делаем пустую строку
                line = (char *)calloc(1, sizeof(char));
                len = 0;
                printf("end stroki\n");
            }
            
            line[strcspn(line, "\n")] = '\0';// удаляем символ конца строки чтобы удобно записать пробел вконце

            if ((byte >> i) & 1) {// двигаем 
                fprintf(out, "%s \n", line); // пробел = 1
                // printf("zapisano1: %s \n", line);
            } else {
                fprintf(out, "%s\t\n", line); // \t = 0 
                // printf("zapisano0: %s \n", line);
            }// сделал для нуля символ так как предполагаю что прятать будем не один символ а несколько ну можно и стереть
    
                // printf("%d", (byte >> i) & 1);
        }
        // читаем следующий байт из ф1 по сути следующий символ , ну можно еще парсером было бы числа сложить и битом записать как одно
        byte_read = fread(&byte, 1, 1, file1);//fread помнит позицию на которой остановилась
    }
    
    // копируем оставшиеся строки из ф2
    while ((read = getline(&line, &len, file2)) != -1) {
        fprintf(out, "%s", line);
    }
    
    free(line);
    fclose(file2);
    fclose(file1);
    fclose(out);
}

int main() {
    char *nazvanya[] = {"F1.txt", "F2.txt", "output.txt"};
    Encode(nazvanya[0], nazvanya[1], nazvanya[2]);
    return 0;
}