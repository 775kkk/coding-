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

char* vstavka_v_str(char* str,char* vstavka,int index){
    char str[100] = "ababa";
    char str2[] = "aba";
    int count = 0;
    for (int i = 0, j = 0; str[i]!='\0'; i++){
        if (str[i] == str2[0]){
            j = 0;
            for (;str2[j]!='\0'; j++){
                if (str[i+j] != str2[j]) break;
            }
        if (str2[j] == '\0') count++;
        }
    }
}

int revers(int a){
    int f = 0;
    while (a>0)
    {
        f= f*10+a%10;
        a=a/10;
    }
    return f;
    
}
int dvoi(int a){
    int f = 1;
    while (a>0)
    {
        f= f*10+a%2;    
        a=a/2;
    }
    return revers(f)/10;
}
int dvoi1(int a){
	int res = 0;
	int toW = 1;
	while(a>0){
		res += (a&1)*toW;
		toW*=10;
		a=a>>1;
	}
	return res;
}
