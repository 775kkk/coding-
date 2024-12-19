#include "stdio.h"

// ===============>
// 3.
void factor(int a){
    int v = 1;
    for (int i = 1; i < a+1; i++){
        v*=i;
    }
    printf("%i", v);  
}
// ===============>
// 4.
int revers(int a){
    int f = 0;
    while (a>0){
        f= f*10+a%10;
        a=a/10;
    }
    return f;
}
// ===============>
// 5.
int isPol(int a){
   int a1=a;
    int f = 0;
    while (a>0){
        f= f*10+a%10;
        a=a/10;
    }
    if (f==a1){
        return 1;
    }
    return 0;
}
// ===============>
// 6.
int revers(int a){
    int f = 0;
    while (a>0){
        f= f*10+a%10;
        a=a/10;
    }
    return f;
}
int dvoi(int a){
    int f = 1;
    while (a>0){
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
// ===============>
// 1.
    for (int i = 0; i < 21; i+=2)
    {
        printf("%i\n", i);
    }
// ===============>
// 2.
    int a, b;
    scanf("%i%i", &a, &b);
    if (a<b){
        while(a<b+1){
           printf("%i\n", a);
           a++;
        }
    }
    else{
        while(a+1>b){
            printf("%i\n", a);
            --a;
       }
    }
// ===============>
// 3.
    int a;
    scanf("%i", &a);
    factor(a);
// ===============>
// 4.
    int a;
    scanf("%i", &a);
    printf("%i", revers(a));
// ===============>
// 5.
    int a;
    scanf("%i", &a);
    printf("%i", isPol(a));
// ===============>
// 6.
    int a;
    scanf("%i", &a);
    printf("%i\n", dvoi(a));
    printf("%i\n", dvoi1(a));
}
