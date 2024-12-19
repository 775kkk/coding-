#include "stdio.h"

void printMassive(int* arr, int size){
    printf("[");
    for(int i = 0; i < size; i++)
    {
        printf("%i, ",arr[i]);
    }
    printf("\b\b]");
    
}

int main(){
    // const int size = 3;
    // int arr[size] = {1,2,3};// фикс длина
    // arr[0] = 4;
    // arr[1] = 5;
    // arr[2] = 6;
    // printf("%i %i", arr[-1], *(arr+19));// ар+19 прикалываемся и гуляем по памяти на чиле
    // printMassive(arr,size);
    
    
    // int size1 = 20;
    // int arr1[size1];
    // for(int i; i<size1;i++){
    // 	if((i%3)==1){
    // 		arr1[i-1]=i;
	// 	}
	// 	if((i%3)==2){
    // 		arr1[i-1]=i*i;
	// 	}
	// 	if((i%3)==0){
    // 		arr1[i-1]=i*2;
	// 	}
	// }
    // printMassive(arr1,size1);
    
    int size =3;
    int arr[size] = {1,2,3};// фикс длина
    for (int i = 0; i < size; i++)
    {
        for (int t = 0; t<size; t++)
        {
            printf("%i%i\n",arr[i],arr[t]);   
        }
        
    }
    

}
