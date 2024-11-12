#include "stdio.h"
#include "../one.h"
int main(){
    // есть массив на какуюто его поз вставить число
    int a = 2;
    int b = 2;
    // scanf("%i введи ",&a);
    int len = 4;
    int arr[len] ;
    arr[a]=b;
    printf("%i", arr[5]);
    printMassive(arr,len);
    printMassive( vstavka_v_mass(arr,len,2,0) , len+1);
}
