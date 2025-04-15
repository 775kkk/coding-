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

void Decode(const char* encoded_file, const char* output_file) {
    FILE *encoded = fopen(encoded_file, "r"); // Файл с закодированными данными
    FILE *output = fopen(output_file, "wb"); // Файл для записи декодированных данных

    if (!encoded || !output) {
        printf("Error opening files\n");
        exit(1);
    }

    char *line = NULL;
    size_t len = 0;
    ssize_t read;
    unsigned char byte = 0;
    int bit_position = 7; // Начинаем с самого старшего бита

    // Читаем строки из закодированного файла
    while ((read = getline(&line, &len, encoded)) != -1) {
        // Убираем символ новой строки
        line[strcspn(line, "\n")] = '\0';

        // Проверяем последний символ строки
        size_t line_length = strlen(line);
        if (line_length > 0) {
            char last_char = line[line_length - 1];

            // Если последний символ - \t (табуляция), бит = 0
            if (last_char == '\t') {
                byte &= ~(1 << bit_position); // Устанавливаем бит в 0
            }
            // Если последний символ - \r (возврат каретки), бит = 1
            else if (last_char == ' ') {
                byte |= (1 << bit_position); // Устанавливаем бит в 1
            } else {
                // Если нет \t или \r, пропускаем строку
                continue;
            }

            // Переходим к следующему биту
            bit_position--;

            // Если все 8 бит обработаны, записываем байт в файл
            if (bit_position < 0) {
                fwrite(&byte, sizeof(unsigned char), 1, output);
                byte = 0; // Сбрасываем байт
                bit_position = 7; // Сбрасываем позицию бита
            }
        }
    }

    free(line);
    fclose(encoded);
    fclose(output);
}

int main() {
    char *names[] = {"dz7_decode", "output.txt", "decoded.txt"};
    Decode(names[1], names[2]);
    printf("Decoding complete. Decoded data saved to %s\n", names[2]);
    return 0;
}