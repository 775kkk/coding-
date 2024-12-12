#include <stdio.h>
#include <string.h>
#include <ctype.h>

void vstavkaVmass(char* strMain, char* strSub, int poz) {
    int lenMain = strlen(strMain);
    int lenSub = strlen(strSub);
    
    // Сдвигаем основную строку, чтобы освободить место для подстроки
    for (int i = lenMain + lenSub - 1; i >= poz + lenSub; i--) {
        strMain[i] = strMain[i - lenSub];
    }

    // Вставляем подстроку
    for (int i = 0; i < lenSub; i++) {
        strMain[poz + i] = strSub[i];
    }

    // Обеспечиваем правильный завершающий нулевой символ
    strMain[lenMain + lenSub] = '\0';
}

void addStudents(char* spisokMain, char* spisokSecond) {
    int nameStrt = 0;
    int nameLen = 0;
    int age = 0;

    // Нужно найти имя и возраст из spisokSecond
    for (int i = 0; i < strlen(spisokSecond); i++) {
        if (isalnum(spisokSecond[i])) {
            if (nameStrt == 0) {
                nameStrt = i;  // начало имени
            }
            nameLen++;
        } else if (nameLen > 0) {
            // Найдем конец имени
            break;
        }
    }

    // Получаем возраст, предполагаем что он состоит из цифр
    for (int i = nameStrt + nameLen; i < strlen(spisokSecond); i++) {
        if (isdigit(spisokSecond[i])) {
            age = age * 10 + (spisokSecond[i] - '0');
        }
    }

    // Нужно найти позицию для вставки
    int poz = 0;
    int perVage = 0;
    int ageM = 0;
    int perVpoz = 0;
    int nameStart = 0;
    int nameLength = 0;

    for (int i = 0; i < strlen(spisokMain); i++)
    {
        if (isalnum(spisokMain[i]) && (i == 0 || !isalnum(spisokMain[i - 1])))
        {
            nameStart = i;
            nameLength = 0;
            while (i + nameLength < strlen(spisokMain) && isalpha(spisokMain[i + nameLength])) {
                nameLength++;
            }
        }

        // Обрабатываем возраст, если встречаем запятую
        if (spisokMain[i] == ',' || spisokMain[i] == '\0')
        {
            // Прочитаем возраст
            ageM = 0;
            for (int j = nameStart + nameLength + 1; j < i && spisokMain[j] != ','; j++) {
                if (isdigit(spisokMain[j])) {
                    ageM = ageM * 10 + (spisokMain[j] - '0');
                }
            }

            // Если новый возраст должен быть вставлен
            if (age > ageM) {
                poz = perVpoz;
            }

            perVpoz = i + 1;
            perVage = ageM;
        }
    }

    // Добавляем запятую и завершающий нулевой символ к spisokSecond
    int lenSecond = strlen(spisokSecond);
    spisokSecond[lenSecond] = ',';
    spisokSecond[lenSecond + 1] = '\0';

    // Вставляем строку
    vstavkaVmass(spisokMain, spisokSecond, poz);
}

int main() {
    char students[50] = "Nikitos 1 , Vanek 2, Valerka 10, Nastya 99";
    char dobavut[40] = "leksys 11";
    addStudents(students, dobavut);
    puts(students);  // Выведет результат
    return 0;
}
