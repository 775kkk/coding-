#include <stdio.h>
#define SIZE 10
#define SIZE2 11

int findChislo(int arr[],int arr2[],int arr3[],int size1,int size2,int size3){
    // так как список отсортирован по возрастанию
    int i=0;
    int j=0;
    int k=0;
    while (i < size1 && j < size2 && k < size3) {
        if ((arr[i] == arr2[j]) && (arr2[j] == arr3[k])) {
            return arr[i];
        }
        if (arr[i]<arr2[j]) {
            i++;
        } else if (arr2[j]<arr3[k]) {
            j++;
        } else {
            k++;
        }
    }
    return NULL;
}

int main(){
    int arr1[SIZE2]={1,2,3,4,5,6,7,8,9,1110,19};
    int arr2[SIZE]={11,12,13,14,15,16,17,18,19,110};
    int arr3[SIZE]={21,22,23,24,25,26,27,28,29,110};
    int chislo = findChislo(arr1,arr2,arr3,SIZE,SIZE2,SIZE2);
    printf("%i",chislo);
}