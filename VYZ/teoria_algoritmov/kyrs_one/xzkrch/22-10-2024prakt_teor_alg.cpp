#include "stdio.h";

int sum(int a, int b){
    return a+b;
}
int del(int a, int b){
    return a/b;
}
int ymn(int a,int b){
    return a*b;
}
int kvad(int a){
    return a*a;
}

int pole(int a){
    int a1=a;
    int f = 0;
    while (a>0)
    {
        f= f*10+a%10;
        a=a/10;
    }
    if (f=a1)
    {
        return 1;
    }
    return 0;
}

int main(){
    printf("%i", pole(102));
    // int x;
    // scanf("%i", &x);
    // for (int i = 0; i<=x; i++)
    // {
    //     for (int j = 0; j < i; j++)
    //     {
    //         printf("*");
    //     }
    //     printf("\n");
    // }
    // printf("\n");
    // for (int i = x; i>=0; i--)
    // {
    //     for (int j = i; j > 0; j--)
    //     {
    //         printf("*");
    //     }
    //     printf("\n");
    // }
    

}
