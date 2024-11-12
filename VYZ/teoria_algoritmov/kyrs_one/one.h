#include "stdio.h"
void printMassive(int* arr, int size){
    printf("[");
    for(int i = 0; i < size; i++)
    {
        printf("%i, ",arr[i]);
    }
    printf("\b\b]");
}
int* vstavka_v_mass( int arr[],int size, int poz, int znachenie){
    // mass,size,number,znachenie
    int arr2[size+1];
    for (int i = 0, j =0; i < size+1; j++)
    {
        if (i==poz)
        {
            arr2[j] = znachenie;
        }
        else{
            arr2[j] = arr[i];
            i++;
        }
    }
    return arr2;
}
