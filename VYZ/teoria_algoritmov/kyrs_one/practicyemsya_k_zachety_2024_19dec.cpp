#include <stdio.h>
#include <malloc.h>

// ========================================================================== 
//                                СТРОКА 
// ==========================================================================

// определяем длину строчного массива
size_t strLen(char* str) {
    size_t i = 0;
    while (str[i] != '\0') {
        i++;
    }
    return i;
}

// вставляем строку в строка
void vstavkaVmass(char* strMain, char* strSub, size_t poz) {
    size_t lenMain = strLen(strMain);
    size_t lenSub = strLen(strSub);
    size_t j = lenSub-1;
    for (int i = lenMain + lenSub; i >= (int)poz; i--) {
        if (i >= (int)(lenSub + poz)) {
            strMain[i] = strMain[i - lenSub];
        } else {
            strMain[i] = strSub[j];
            j--;
        }
    }
    strMain[lenMain + lenSub] = '\0'; 
}

// вставляем символ в строку
void vstavkaVmass(char* strMain, char Sub, size_t poz){
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

// вставка символа в маллок массив
void mallocVstavka(char** str, char symbol) {
    *str = (char*)realloc(*str, (strLen(*str)+2)*sizeof(char));
    size_t poz = strLen(*str) > 0 ? strLen(*str) - 1 : 0;
    vstavkaVmass(*str, symbol, poz);
}

// вставка символа в нужную позицию в маллок массиве
void mallocVstavka(char** str, char symbol, size_t poz) {
    *str = (char*)realloc(*str, (strLen(*str)+2)*sizeof(char));
    vstavkaVmass(*str, symbol, poz);
}

// вставка строки в маллок массив
void mallocVstavka(char** str, char* subStr) {
    *str = (char*)realloc(*str, (strLen(*str)+strLen(subStr) + 1)*sizeof(char));
    size_t poz = strLen(*str) > 0 ? strLen(*str) - 1 : 0;
    vstavkaVmass(*str, subStr, poz);
}

// вставка строки в нужную позицию в маллок массиве
void mallocVstavka(char** str, char* subStr, size_t poz) {
    *str = (char*)realloc(*str, (strLen(*str)+strLen(subStr) + 1)*sizeof(char));
    vstavkaVmass(*str, subStr,poz);
}

// инициализация массива -> маллока с сразу вставкой текста char
// char* initializ_str(char* strM){
//     char* str = (char*)malloc((strLen(strM)+1) * sizeof(char));
//     if (strLen(strM) > 0) {
//         vstavkaVmass(str, strM, 0);
//     } else {
//         str[0] = '\0';
//     }
//     return str;
// }
char* initializ_str(char* strM){
    size_t len = strLen(strM);
    char* str = (char*)malloc((len + 1) * sizeof(char));
    if (len > 0) {
        for (size_t i = 0; i < len; i++) {
            str[i] = strM[i];
        }
        str[len] = '\0';
    } else {
        str[0] = '\0';
    }
    return str;
}

// ========================================================================== 
//                                ЧИСЛА 
// ==========================================================================



// ===================>>>>>>>>
// 1. написать функц которая принимает 3 строки как массивы символов 
// необходимо из первой строки заменить слово, записанное во второй строке на слово из третьей


int main(){
        // тест строковых функций
    // char str1[] = "dsdsadas";
    // char* str = initializ_str(str1);
    // puts(str);
    // printf("len = %i\n", strLen(str));
    // ✅✅✅✅✅✅✅✅✅✅✅✅✅✅

// ===================>>>>>>>>
// 1. написать функц которая принимает 3 строки как массивы символов 
//    необходимо из первой строки заменить слово, записанное во второй строке на слово из третьей
    

}
