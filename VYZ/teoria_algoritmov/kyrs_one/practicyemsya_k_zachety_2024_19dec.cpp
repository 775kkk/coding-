#include <stdio.h>
#include <malloc.h>

size_t strLen(char* str) {
    size_t i = 0;
    while (str[i] != '\0') {
        i++;
    }
    return i;
}

void vstavkaVmass(char* strMain, char* strSub, size_t poz) {// строка
    size_t lenMain = strLen(strMain);
    size_t lenSub = strLen(strSub);
    size_t j = lenSub-1;
    for (size_t i = lenMain + lenSub; i >= poz; i--) {
        if (i >= lenSub + poz) {
            strMain[i] = strMain[i - lenSub];
        } else {
            strMain[i] = strSub[j];
            j--;
        }
    }
    strMain[lenMain + lenSub] = '\0'; 
}
void vstavkaVmass(char* strMain, char Sub, size_t poz){// символ
    size_t lenMain = strLen(strMain);
    size_t lenSub = 1;
    size_t j = lenSub-1;
    for (size_t i = lenMain + lenSub; i >= poz; i--){
        if (i >= lenSub + poz){
            strMain[i] = strMain[i - lenSub];
        }
        else{
            strMain[i] = Sub;
            j--;
        }   
    }
    strMain[lenMain + lenSub] = '\0';
}

void mallocVstavka(char** str, char symbol) {// добавление символа
    *str = (char*)realloc(*str, (strLen(*str)+2)*sizeof(char));
    size_t poz = strLen(*str) > 0 ? strLen(*str) - 1 : 0;
    vstavkaVmass(*str, symbol, poz);
}
void mallocVstavka(char** str, char symbol, size_t poz) {// вставка символа в нужную позицию
    *str = (char*)realloc(*str, (strLen(*str)+2)*sizeof(char));
    vstavkaVmass(*str, symbol, poz);
}
void mallocVstavka(char** str, char* subStr) {// добавление строки
    *str = (char*)realloc(*str, (strLen(*str)+strLen(subStr) + 1)*sizeof(char));
    size_t poz = strLen(*str) > 0 ? strLen(*str) - 1 : 0;
    vstavkaVmass(*str, subStr, poz);
}
void mallocVstavka(char** str, char* subStr, size_t poz) {// вставка строки в нужную позицию
    *str = (char*)realloc(*str, (strLen(*str)+strLen(subStr) + 1)*sizeof(char));
    vstavkaVmass(*str, subStr,poz);
}

char* initializ_str(char* strM){
    char* str = (char*)malloc((strLen(strM)+1) * sizeof(char));
    if (strLen(strM) > 0) {
        vstavkaVmass(str, strM, 0);
    } else {
        str[0] = '\0';
    }
    return str;
}
// ===================>>>>>>>>
// 1. написать функц которая принимает 3 строки как массивы символов 
// необходимо из первой строки заменить слово, записанное во второй строке на слово из третьей


int main(){
// ===================>>>>>>>>
// 1. написать функц которая принимает 3 строки как массивы символов 
//    необходимо из первой строки заменить слово, записанное во второй строке на слово из третьей
    char* str = (char*)malloc(6 * sizeof(char)); // Выделяем память для "Hello"
    if(str == NULL){
        printf("Ошибка выделения памяти\n");
    }
}