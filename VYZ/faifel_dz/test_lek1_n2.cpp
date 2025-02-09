#include <stdio.h>
int main(){
    int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5,8};
    int lenArr = sizeof(arr)/sizeof(arr[0]);

    int uniqueIndex = 0;
    // Проходим по массиву и сохраняем уникальные элементы
    for (int i = 1; i < lenArr; i++) {
        if (arr[i] != arr[uniqueIndex]) {
            arr[++uniqueIndex] = arr[i];
        }
    }

    for (size_t i = 0; i < lenArr; i++)
    {
        printf("%i ", arr[i]);
    }
    printf("\n%i",uniqueIndex+1);
}