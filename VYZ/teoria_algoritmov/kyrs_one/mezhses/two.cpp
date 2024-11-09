#include "stdio.h"
int main(){
int a, b;
scanf("%i%i", &a, &b);
if (a<b)
{
    while(a<b+1)
    {
        printf("%i\n", a);
        a++;
    }
    
}
else 
{
    while(a+1>b)
    {
        printf("%i\n", a);
        --a;
    }
    
}

}
