#include "stdio.h"

int revers(int a){
    int f = 0;
    while (a>0)
    {
        f= f*10+a%10;
        a=a/10;
    }
    return f;

}
int main(){
    int a;
    scanf("%i", &a);
    printf("%i", revers(a));
}