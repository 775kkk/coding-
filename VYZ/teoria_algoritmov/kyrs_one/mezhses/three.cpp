#include "stdio.h"

void factor(int a){
    int v = 1;
    for (int i = 1; i < a+1; i++)
    {
        v*=i;
    }
    printf("%i", v);
    
}
int main(){
    int a;
    scanf("%i", &a);
    factor(a);



}
