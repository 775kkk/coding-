#include "stdio.h"
#include <malloc.h>
// #include <myfunc.h> напишу напрямую тут

//проверка с чем работаем с данам или нет <myfunc.h>
// bool dynamic(int* arr) {
//     if (arr == NULL) {
//         return false;
//     }
//     // Попробуем выделить дополнительную память
//     void* newptr = realloc(arr, 0);
//     if (newptr == NULL) {
//         return false; // значит память не динамическая
//     }
//     else{
//     return true; // значит да
//     }
// }



// сортировка массива по возрастанию <myfunc.h>
void sorted(int* stroka,int Mlen){
    int sortLen = 0;
    int NEsortLen = Mlen;
    int min;
    int mIndex=0;
    while (sortLen!=Mlen){   
        min=32767;
        for (int i = sortLen; i!=Mlen; i++){
            if (stroka[i]<min){
                min=stroka[i];
                mIndex=i;
            }
        }
        stroka[mIndex]=stroka[sortLen];
        stroka[sortLen]=min;
        sortLen++;
    }
}

// убрать повторения из массива
int ynikalnost(int* arr, int lenArr){
    sorted(arr,lenArr);// сортируем
    size_t j = 0;
    // Проходим по массиву и сохраняем уникальные элементы
    for (int i = 1; i < lenArr; i++) {
        if (arr[i] != arr[j]) {
            arr[++j] = arr[i];
        }
    }
    // делаем чтото в зависимтости от того явл ли массив динамическим
    // if (dynamic(arr)) {
    //     arr = (int*)realloc(arr, (j+1) * sizeof(int));
    // }
    // else {
    //     int* newarr = (int*)malloc((j+1) * sizeof(int));
    //     for (size_t i = 0; i < j+1; i++) {
    //         newarr[i] = arr[i];
    //     }
    //     arr = newarr;
    // }
    //j+1 - количество уникальных элементов, индексация с нуля
    // не знаю как лучше упаковать данные поэтому просто изменю массив а верну новую длинну
    return j+1;
    
}

int main(){
    // убрать повторения из массива
    int lenArr = 10; 
    int arr[lenArr]= {1,2,3,4,3,6,6,9,9,9};
    int newLen = ynikalnost(arr,lenArr);
    for (int i = 0; i < newLen; i++)
    {
        printf("%i ",arr[i]);
    }
}