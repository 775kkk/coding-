#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void justify_text(FILE *input, FILE *output, int width) {
    char line[1000];
    while (fgets(line, sizeof(line), input)) {
        int len = strlen(line);
        if (line[len-1] == '\n') line[len-1] = '\0';
        
        char *words[100];
        int word_count = 0;
        
        // Разбиваем строку на слова
        char *token = strtok(line, " ");
        while (token != NULL) {
            words[word_count++] = token;
            token = strtok(NULL, " ");
        }
        
        if (word_count == 0) {
            fputc('\n', output);
            continue;
        }
        
        // Вычисляем общую длину слов без пробелов
        int total_length = 0;
        for (int i = 0; i < word_count; i++) {
            total_length += strlen(words[i]);
        }
        
        // Количество необходимых пробелов
        int total_spaces = width - total_length;
        int gaps = word_count - 1;
        
        if (gaps <= 0) {
            fprintf(output, "%s\n", words[0]);
            continue;
        }
        
        // Распределяем пробелы между словами
        int spaces_per_gap = total_spaces / gaps;
        int extra_spaces = total_spaces % gaps;
        
        // Формируем строку
        for (int i = 0; i < word_count; i++) {
            fprintf(output, "%s", words[i]);
            if (i < gaps) {
                for (int j = 0; j < spaces_per_gap; j++) fputc(' ', output);
                if (i < extra_spaces) fputc(' ', output);
            }
        }
        fputc('\n', output);
    }
}

int main() {
    FILE *input = fopen("input.txt", "r");
    FILE *output = fopen("output.txt", "w");
    int width = 80; // Желаемая ширина строки
    
    if (input == NULL || output == NULL) {
        printf("Ошибка открытия файлов\n");
        return 1;
    }
    
    justify_text(input, output, width);
    
    fclose(input);
    fclose(output);
    return 0;
}