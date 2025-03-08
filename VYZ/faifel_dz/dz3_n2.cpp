#include <stdio.h>
#include <malloc.h>

int* findThreeMINchisla(int* arr, int size){
    int* result = (int*)malloc(3*sizeof(int));
    int min1=32767;
    int min2=32767;
    int min3=32767;
    for (int i = 0; i < size; i++) {
        if (arr[i]<min1) {
            min3=min2;
            min2=min1;
            min1=arr[i];
        } else if (arr[i]<min2) {
            min3=min2;
            min2=arr[i];
        } else if (arr[i]<min3) {
            min3=arr[i];
        }
    }

    result[0]=min1;
    result[1]=min2;
    result[2]=min3;
    return result;
}

int main(){
    int arr[11]={22,2,3,4,5,6,7,8,1,1110,19};
    int* result = findThreeMINchisla(arr,11);
    for (int i = 0; i < 3; i++){
        printf("%i  ",result[i]);
    }
}