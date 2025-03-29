#include <stdio.h>

long stepen2(int n) {
    return 2 << n;
}
int zadacha(){
    int result=0;//n
    for (int i = 0; i < 1000; i++)
    {
        //2^n - n ? n=0 ok i=n result!=0
        if ((stepen2(i)-i)%7==0)
        {
            result++;
        }
    }
    return result;
}

int main()
{
    printf("otvet %i",zadacha());
}
