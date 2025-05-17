#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

// проверка соовпадения с паттерном (умная)
bool testPattern(const char *pattern, const char *str) {
    if (*pattern == '\0' && *str == '\0'){
        return true;
    }
    if (*pattern == '*') {
        // Пропускаем последовательные * // выелом их скипаем тк нам пох
        while (*pattern == '*') {
            pattern++;// ++ счетчик -> просто далее двигаем
        }
        if (*pattern == '\0'){
            return true;// есле у нас тупа звезды были то сразу ретурним тру так как нам пох че там в строке
        }
        while (*str != '\0') {// паттерн не кончился значит там еще куча всякого , рекурсивно проверяем
            if (testPattern(pattern, str)){//хитрожопо на этом держится вся логика(вся функция) так как (testPattern(pattern, str) тру только в случае когда у нас кончился либо паттерн на звезду либо и паттерн и строка)))))))))))))
                return true;
            }
            str++;
        }
        return false;// старанно так как у нас тупа з
    }// НАМ ОЧЕНЬ СИЛЬНО ПОХ НА ЗВЕЗДЫ БУКВАЛЬНО МЫ ИХ ЗА НИЧТО СЧИТАЕМ))))
    if (*pattern == '?' || *pattern == *str){// это тупа для рекурсии вызванной в 19 строке( на 8 строк ниже)
        return testPattern(pattern + 1, str + 1);// таким образом идем до *pattern == '\0' && *str == '\0' или до конца паттерна(*pattern == '\0') при условии что(*pattern[-1] == '*') в конце звезда
    }
    return false;
}
// bool mailTEST(char * str){
//     return strcmp(str+(strlen(str)-54), "mail");
// }
// bool patternEasyTEST(char *pattern){
//     // НАДО НАМ БЫ ОПРЕДЕЛИТЬСЯ С ВХОДНЫМИ ДАННЫМИ)))))))))))))))))))))))
//     //  БУДЕМ СЧИТАТЬ ЧТО МЫ ГЛУПЫЕ И СЧИТАЕМ mail ЧАСТЬЮ ПОТТЕРНА)))))
//     // НЕТ ВЫ МОЖЕТ И ТУПЫЕ НО Я mail УБЕРУ ИЗ ПАТТЕРНА
    // хуйня все

//     return false;
// }
// bool testPattern2(char* pattern, char * str){
//     if (condition)
//     {
//         /* code */
//     }
//     if (*pattern=='*')
//     {
//         /* code */
//     }
//     if (*pattern==*str)
//     {
//         return true;
//     }
//     return false;
// }



// задание 2 (перекосоёёбм паттерн)
void transformPattern(char *pattern, int count) {
    char buffer[256] = {0};
    int buf_index = 0;
    int count_index = 0;
    char count_str[20];
    sprintf(count_str, "%d", count);// число в строку
    
    for (int i = 0; pattern[i] != '\0'; i++) {
        if (pattern[i] == '?') {
            if (count_index < strlen(count_str)) {// чтобы не выйти за пределы (увелич count_str)
                buffer[buf_index++] = count_str[count_index++];
                buffer[buf_index++] = '*';
            }
        } else {
            buffer[buf_index++] = pattern[i];
        }
    }
    buffer[buf_index] = '\0';
    strcpy(pattern, buffer);
}

// проста считаем колво совпадений с паттерном из массива пимеров
int schetSovpadeniuPatternov(const char *pattern, char **strings, int count) {
    int sovpadenya = 0;
    for (int i = 0; i < count; i++) {
        if (testPattern(pattern, strings[i])) {
            sovpadenya++;
        }
    }
    return sovpadenya;
}
// ретурним массив колва совпадений массива паттернов с массивом строк, ориентироваться по индексу
int *SkolkoSovpadeniyMassPatternsANDmassExamples(char **patterns, int pattern_count, char **strings, int string_count) {
    int *sovpadenya = (int *)malloc(pattern_count * sizeof(int));
    for (int i = 0; i < pattern_count; i++) {
        sovpadenya[i] = schetSovpadeniuPatternov(patterns[i], strings, string_count);
    }
    return sovpadenya;
}

// Функция для объединения двух самых частых образцов
char *combiningTopPatterns(char **patterns, int *sovpadenya, int patternCount) {
    if (patternCount < 2){
        return NULL;
    }
    int first = 0, second = 0;
    int first_index = 0, second_index = 0;
    for (int i = 0; i < patternCount; i++){
        if (sovpadenya[i] > first) {
            second = first;
            second_index = first_index;
            first = sovpadenya[i];
            first_index = i;
        } else if (sovpadenya[i] > second) {
            second = sovpadenya[i];
            second_index = i;
        }
    }
    
    char *combining = (char *)malloc(strlen(patterns[first_index]) + strlen(patterns[second_index]) + 1);
    strcpy(combining, patterns[first_index]);
    strcat(combining, patterns[second_index]);
    return combining;
}

int main() {
    char *tests[] = {"abc.ymail", "test.1mail", "xyz.2mail", "wrong.male", "a.bmail","wrong.male", "a.ZZZZ@WbmailWWW",".Wmail00000000.Zmail"};
    char *patterns[] = {"*.?mail", "*.?mail*", "test*", "*mail","ZZZZZZZZZZZZZZZ","WWWW"};
    int patternsCount = 6;
    int testsCount = 8;
    printf("test mail: ");
    for (int i = 0; i < testsCount; i++)
    {
        printf("%s ", tests[i]);
    }
    printf("\ntest patterns: ");
    for (int i = 0; i < patternsCount; i++)
    {
        printf("%s ", patterns[i]);
    }
    printf("\n");
    printf("\n");
    
    

    printf("Zadacha 1\n");
    printf("abc.ymail sovpadenya s *.?mail: %s\n", testPattern(patterns[0], tests[0]) ? "true" : "false");
    printf("wrong.male sovpadenya s *.?mail: %s\n", testPattern(patterns[0], tests[3]) ? "true" : "false");
    printf("*.?mail**.?mail* sovpadenya s .Wmail00000000.ZmailZ : %s\n", testPattern("*.?mail*.?mail*", tests[7]) ? "true" : "false");

    printf("\nZadacha 2\n");
    int sovpadenya = schetSovpadeniuPatternov(patterns[0], tests, testsCount);
    printf("sovpadenya: %i, %s s example data  \n", sovpadenya, patterns[0]);
    char pattern_copy[20];
    strcpy(pattern_copy, patterns[0]);
    transformPattern(pattern_copy, sovpadenya);
    printf("transformPattern: %s\n", pattern_copy);

    printf("\nZadacha 3\n");
    printf("sovpadenya full data\n");
    int *sovpadenyaMass = SkolkoSovpadeniyMassPatternsANDmassExamples(patterns, patternsCount, tests, testsCount);
    for (int i = 0; i < patternsCount; i++){
        printf("sovpadenya[%d] %s: %d\n", i,patterns[i], sovpadenyaMass[i]);
    }
    printf("\n");

    printf("\nZadacha 4\n");
    char *TOPPattern = combiningTopPatterns(patterns, sovpadenyaMass, patternsCount);
    printf("TOPPattern (combining): %s\n", TOPPattern);
    int TOPPatternSovpadenya = schetSovpadeniuPatternov(TOPPattern, tests, testsCount);
    printf("TOPPattern sovpadenya: %d\n", TOPPatternSovpadenya);
    free(sovpadenyaMass);
    free(TOPPattern);
}