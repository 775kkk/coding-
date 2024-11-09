#include "stdio.h"

 int isPol(int a){
   int a1=a;
    int f = 0;
    while (a>0)
    {
        f= f*10+a%10;
        a=a/10;
    }
    if (f==a1)
    {
        return 1;
    }
    return 0;
 }
int main(){
int a;
scanf("%i", &a);
printf("%i", isPol(a));

}
    
