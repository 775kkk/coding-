#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>

int strLen(char* str) {
    int i = 0;
    for (; str[i] != '\0'; i++) {}
    return i;
}

void vstavkaVmass(char* strMain, char* strSub, int poz) {
    int lenMain = strLen(strMain);
    int lenSub = strLen(strSub);
    // Сдвигаем основной массив вправо, чтобы освободить место для нового студента
    for (int i = lenMain; i >= poz; i--) {
        strMain[i + lenSub] = strMain[i]; // Увеличиваем длину на lenSub
    }
    // Вставляем нового студента
    for (int i = 0; i < lenSub; i++) {
        strMain[poz + i] = strSub[i];
    }
}

void addStudents(char* spisokMain, char* spisokSecond) {
    int nameStrt = 0;
    int nameLen = 0;

    // Находим длину имени и его начало
    for (int i = 0; i < strLen(spisokSecond); i++) {
        if (isalnum(spisokSecond[i])) {
            if (nameStrt == 0) {
                nameStrt = i; // Начало имени
            }
            nameLen++;
        }
    }

    // Извлекаем возраст
    int age = 0;
    for (int i = nameStrt + nameLen; spisokSecond[i] != '\0'; i++) {
        if (isdigit(spisokSecond[i])) {
            age = age * 10 + (spisokSecond[i] - '0');
        }
    }

    // Определяем позицию для вставки
    int poz = 0;
    int perVage = 0;
    int ageM = 0;
    bool point = false;

    for (int i = 0; spisokMain[i] != '\0'; i++) {
        if (isalnum(spisokMain[i])) {
            if (point) {
                ageM = ageM * 10 + (spisokMain[i] - '0');
            }
        }
        if (spisokMain[i] == ',' || spisokMain[i + 1] == '\0') {
            if (ageM > 0 && (perVage < age && age < ageM)) {
                poz = i + 1; // Вставляем после запятой
                break;
            }
            perVage = ageM;
            ageM = 0;
            point = false;
        }
        if (spisokMain[i] == ' ') {
            point = true;
        }
    }

    // Добавляем запятую и нуль-терминатор
    int sssssss = strLen(spisokSecond);
    spisokSecond[sssssss] = ',';
    spisokSecond[sssssss + 1] = '\0';

    // Вставляем нового студента
    vstavkaVmass(spisokMain, spisokSecond, poz);
}

int main() {
    char students[100] = "Nikitos 1, Vanek 2, Valerka 10, Nastya 99";
    char dobavut[40] = "leksys 4";
    addStudents(students, dobavut);
    puts(students);
    return 0;
}
