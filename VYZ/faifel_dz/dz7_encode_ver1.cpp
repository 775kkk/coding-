#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//char *line = NULL;
// getline(&line, &len, file) != -1
// free(line);
ssize_t getline(char **lineptr, size_t *n, FILE *stream) {// ssize t как size t но допускается только -1 чтобы вернуть и обозначить ошибку таким образом
    if (lineptr == NULL || n == NULL || stream == NULL) {
        return -1;
    }
    size_t pos = 0;
    int c;
    // Если буфер не выделен, выделяем его
    if (*lineptr == NULL) {
        *n = 128; // Начальный размер
        *lineptr = (char *)malloc(*n);
        if (*lineptr == NULL) {
            return -1;
        }
    }
    while ((c = fgetc(stream)) != EOF) { //fgetc читаем символы по одному
        // Увеличиваем буфер, если он заполнен
        if (pos + 1 >= *n) {
            *n *= 2;
            char *new_ptr = (char *)realloc(*lineptr, *n);
            if (new_ptr == NULL) {
                return -1;
            }
            *lineptr = new_ptr;
        }

        // Записываем символ в буфер
        (*lineptr)[pos++] = c;
        // Прерываем чтение, если встречен символ новой строки
        if (c == '\n') {
            break;
        }
    }
    // Если ничего не прочитано, возвращаем -1
    if (pos == 0 && c == EOF) {
        return -1;
    }
    (*lineptr)[pos] = '\0'; // Завершаем строку
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
    
    // Читаем байт из F1
    int byte_read = fread(&byte, 1, 1, file1);
    while (byte_read == 1) {
        // Обрабатываем каждый бит байта
        for (int i = 7; i >= 0; i--) {
            // Читаем строку из F2
            if ((read = getline(&line, &len, file2)) == -1) {
                    printf("Error reading F2\n");
                    exit(1);
            }
            line[strcspn(line, "\n")] = '\0';// удаляем символ конца строки чтобы удобно записать пробел вконце

            if ((byte >> i) & 1) {// если бит = 1
                fprintf(out, "%s \n", line); // пробел = 1
            } else {
                fprintf(out, "%s\t\n", line); // \t = 0 
            }// сделал для нуля символ так как предполагаю что прятать будем не один символ а несколько и все умещать в имеющиеся строки
        }
        // Читаем следующий байт из F2
        byte_read = fread(&byte, 1, 1, file1);//fread помнит позицию на которой остановилась
    }
    
    // Копируем оставшиеся строки из F1
    while ((read = getline(&line, &len, file2)) != -1) {
        fprintf(out, "%s", line);
    }
    
    free(line);
    fclose(file2);
    fclose(file1);
    fclose(out);
}

int main() {
    char *names[] = {"dz7_encode", "F1.txt", "F2.txt", "output.txt"};
    Encode(names[1], names[2], names[3]);
    return 0;
}