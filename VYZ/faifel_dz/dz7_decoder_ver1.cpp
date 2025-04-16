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
    if (*lineptr == NULL) {
        *n = 128; 
        *lineptr = (char *)malloc(*n);
        if (*lineptr == NULL) {
            return -1;
        }
    }
    while ((c = fgetc(stream)) != EOF) { 
        if (pos + 1 >= *n) {
            *n *= 2;
            char *new_ptr = (char *)realloc(*lineptr, *n);
            if (new_ptr == NULL) {
                return -1;
            }
            *lineptr = new_ptr;
        }
        (*lineptr)[pos++] = c;
        if (c == '\n') {
            break;
        }
    }
    if (pos == 0 && c == EOF) {
        return -1;
    }
    (*lineptr)[pos] = '\0';
    return pos;
}

void Decode(const char* encoded_file, const char* output_file) {
    FILE *encoded = fopen(encoded_file, "r"); //  закодированно
    FILE *output = fopen(output_file, "wb"); // туда декодируем

    if (!encoded || !output) {
        printf("error open\n");
        exit(1);
    }

    char *line = NULL;
    size_t len = 0;
    ssize_t read;
    unsigned char byte = 0;
    int bit_position = 7; // старший бит

    while ((read = getline(&line, &len, encoded)) != -1) {
        line[strcspn(line, "\n")] = '\0';

        // проверяем последний символ строки
        size_t line_length = strlen(line);
        if (line_length > 0) {
            char last_char = line[line_length - 1];

            //  - \t табуляция, бит = 0
            if (last_char == '\t') {
                byte &= ~(1 << bit_position); // устанавливаем бит в 0
            }
            //  - прабел, бит = 1
            else if (last_char == ' ') {
                byte |= (1 << bit_position); // устанавливаем бит в 1
            } else {
                // нет \t или  , пропускаем строку
                continue;
            }
            bit_position--;

            // все 8 бит обработаны, записываем  в файл
            if (bit_position < 0) {
                fwrite(&byte, sizeof(unsigned char), 1, output);
                byte = 0; // сбрасываем байт
                bit_position = 7; // сбрасываем позицию бита
            }
        }
    }
    free(line);
    fclose(encoded);
    fclose(output);
}

int main() {
    char *nazvanya[] = { "output.txt", "decoded.txt"};
    Decode(nazvanya[0], nazvanya[1]);
    printf("decoding complete, decoded data saved to %s\n", nazvanya[1]);
}