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
    size_t poz = strLen(*str) > 0 ? strLen(*str)-1 : 0;
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
    size_t poz = strLen(*str) > 0 ? strLen(*str)-1 : 0;
    vstavkaVmass(*str, subStr, poz);
}

// вставка строки в нужную позицию в маллок массиве
void mallocVstavka(char** str, char* subStr, size_t poz) {
    *str = (char*)realloc(*str, (strLen(*str)+strLen(subStr) + 1)*sizeof(char));
    vstavkaVmass(*str, subStr,poz);
}

// инициализация массива -> маллока с сразу вставкой текста char
char* initializ_str(char* strM){
    size_t len = strLen(strM);
    char* str = (char*)malloc((len + 1)*sizeof(char));
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

// вставка чисел в массив
void vstavkaVmass(int* arrMain ,size_t lenMainArr, int* arrSub, size_t lenSub, size_t poz){
    size_t j = lenSub-1;
    for (int i = lenMainArr + lenSub; i >= (int)poz; i--){
        if (i >= (int)(lenSub + poz)){
            arrMain[i] = arrMain[i - lenSub];
        }
        else{
            arrMain[i] = arrSub[j];
            j--;
        }
    }
}

// вставка числа в массив чисел
void vstavkaVmass(int* arrM, size_t lenMainArr, int subChisl, size_t poz){
    size_t lenSub = 1;
    size_t j = lenSub-1;
    for (size_t i = lenMainArr + lenSub; i >= poz; i--){
        if (i >= lenSub + poz){
            arrM[i] = arrM[i - lenSub];
        }
        else{
            arrM[i] = subChisl;
            j--;
        }   
    }
}

// аппенд числа в маллок массив
void mallocVstavka(int** arr,size_t lenMainArr, int chisl){
    *arr = (int*)realloc(*arr, (lenMainArr+1)*sizeof(int));
    size_t poz = lenMainArr > 0 ? lenMainArr-1 : 0;
    vstavkaVmass(*arr,lenMainArr, chisl, poz);
}

// аппенд чисел в маллок массив
void mallocVstavka(int** arrM,size_t lenMainArr, int** arrSub, size_t lenSubArr){
    *arrM = (int*)realloc(*arrM, (lenMainArr+lenSubArr)*sizeof(int));
    size_t poz = lenMainArr > 0 ? lenMainArr-1 : 0;
    vstavkaVmass(*arrM,lenMainArr, *arrSub, lenSubArr, poz);
}

// вставка числа в нужную позицию в маллок массиве
void mallocVstavka(int** arrM, size_t lenMainArr, int chisl, size_t poz){
    *arrM = (int*)realloc(*arrM, (lenMainArr+1)*sizeof(int));
    vstavkaVmass(*arrM, lenMainArr, chisl, poz);
}

// вставка чисел в нужную позицию в маллок массиве
void mallocVstavka(int** arrM, size_t lenMainArr, int* arrSub, size_t LenSubArr, size_t poz){
    *arrM = (int*)realloc(*arrM, (lenMainArr+LenSubArr)*sizeof(int));
    vstavkaVmass(*arrM, lenMainArr, arrSub, LenSubArr, poz);
}

// инициализация массива -> маллок с сразу вставкой чисел int
int* initializ_int(int* arrM, size_t lenMainArr){
    int* RETarr = (int*)malloc(lenMainArr * sizeof(int));
    for (size_t i = 0; i < lenMainArr; i++){
        RETarr[i] = arrM[i];
    }
    return RETarr;
}

// ===================>>>>>>>>
// 1. написать функц которая принимает 3 строки как массивы символов 
// необходимо из первой строки заменить слово, записанное во второй строке на слово из третьей

void zamena(char* str1, char* str2, char* str3){
    size_t len1 = strLen(str1);
    size_t len2 = strLen(str2);
    size_t len3 = strLen(str3);
    int point = 0;
    bool Search = false;
    int j = 0;
    for (size_t i = 0; i < len1; i++){
        if (str1[i]==str2[j]){
            point = i;
            j++;
            // printf("j = %i\n", j);
        }else{
            point = 0;
            j = 0;
        }
        if (j==len2){//тут можн вставить типа чтобы слово было ограничено пробелами типа чтобы не в составе другого слова
            Search = true;
            point=point-len2+1;
            break;
        }
    }
    if (Search){
            // го крч просто удалим че нах не сдалось и пох
        j=point+len2;
        for (size_t i = point; j <= len1; i++){
            str1[i] = str1[j];
            j++;
        }
        str1 = (char*)realloc(str1, (len1-len2+len3)*sizeof(char));
        vstavkaVmass(str1,str3,point);
    }else{
        printf("%i",j);
        puts("Exception!! : Слово не найдено");
    }
}


int main(){
        // тест строковых функций✅
    // char str1[] = "dsdsadas";
    // char* str = initializ_str(str1);
    // puts(str);
    // printf("len = %i\n", strLen(str));
    // ✅✅✅✅✅✅✅✅✅✅✅✅✅✅

        // тест числовых функций✅
    // int len=9;
    // int arr1[9] = {1,2,3,4,5,6,7,8,9};
    // int* arr = initializ_int(arr1, 9);
    // for (size_t i = 0; i < len; i++){
    //     printf("%i", arr[i]);
    // }
    // ✅✅✅✅✅✅✅✅✅✅✅✅✅✅

// ===================>>>>>>>>
// 1. написать функц которая принимает 3 строки как массивы символов 
//    необходимо из первой строки заменить слово, записанное во второй строке на слово из третьей
    
    // char* str1 = initializ_str("leksus, chepyx1 chep chep");
    // char* str2 = initializ_str("chepyx1");
    // char* str3 = initializ_str("leksus");
    // zamena(str1, str2, str3);
    // puts(str1);

    // ✅✅✅✅✅✅✅✅✅✅✅✅✅✅

}
