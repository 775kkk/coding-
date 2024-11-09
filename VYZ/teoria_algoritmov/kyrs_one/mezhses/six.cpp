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

int main(){
    int a;
    scanf("%i", &a);
    printf("%i\n", dvoi(a));
    printf("%i\n", dvoi1(a));

}
