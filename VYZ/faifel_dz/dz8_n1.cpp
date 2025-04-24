#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_WORDS 1000
#define MAX_WORD_LENGTH 100

size_t utf8_strlen(const char* str) {
    size_t count = 0;
    while (*str) {
        if ((*str & 0xC0) != 0x80) {
            count++;
        }
        str++;
    }
    return count;
}

void format_text(FILE *input, FILE *output, int width) {
    char *words[MAX_WORDS]; // храним слова
    int word_count = 0;

    
    char line[1000]; // буфер для чтения строк
    while (fgets(line, sizeof(line), input)) {// читаем
        int len = strlen(line);// тут обычный strlen так как речь про память а не колво символов см стр40
        if (line[len - 1] == '\n') line[len - 1] = '\0';
        char *nowSlovo = strtok(line, " ");
        while (nowSlovo != NULL) {
            words[word_count] = (char *)malloc(strlen(nowSlovo) + 1);
            strcpy(words[word_count], nowSlovo);
            word_count++;
            nowSlovo = strtok(NULL, " ");// последовательно разбираем строку
        }
    }

    int current_length = 0;
    for (int i = 0; i < word_count; i++) {
        int word_length = utf8_strlen(words[i]);//обычный strlen не подойдет так как вернет размер а не колво символов, а размер русской буквы А 2 байта к примеру, когда латинская 1 байт
    
        // поместится ли текущее слово в строку
        if (current_length > 0 && current_length + word_length + 1 > width) {
            fputc('\n', output);
            current_length = 0;
        }
        // если это не первое слово в строке то после пробел, по логике получается перед, чтобы перед \n не было пробела
        if (current_length > 0) {
            fputc(' ', output);
            current_length++;
        }
        // слово
        fprintf(output, "%s", words[i]);
        current_length += word_length;
    }
    fputc('\n', output); // дописываем

    for (int i = 0; i < word_count; i++) {
        free(words[i]);
    }
}

int main() {
    FILE *input = fopen("input_DZ8N1.txt", "r");
    FILE *output = fopen("output_DZ8N1.txt", "w");
    int width = 50;
    if (input == NULL || output == NULL) {
        printf("open error\n");
    }

    format_text(input, output, width);
    fclose(input);
    fclose(output);
}