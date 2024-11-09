#include "stdio.h";

int main(){

// 0.1
//     int x;
//     scanf("%i", &x);
//     printf("%i", 1 & x);

//1
    // int x;
    // scanf("%i", &x);
    // printf("%i", 1 & x>>4);

//2
    // int x;
    // scanf("%i", &x);
    // printf("%i", 1 & x>>3 & x>>1);

//3
    // int x;
    // scanf("%i", &x);
    // printf("%i", (1 & x>>3 & x>>1) | ((0 & (x>>3 & x>>1)) | 1) | 0);

//4
    // int x;
    // scanf("%i", &x);
    // printf("%i", 2<<(x-1));

// 5
    int x;
    scanf("%i", &x );
    // printf("%i", x<<4,(x-2)>>x<<1,(x-3)<<x>>2,(x-4)>>x<<3,(x-1)<<x );//1011
    // printf("%i",(x-1)<<x,(x-4)>>x<<3,(x-3)<<x>>2,(x-2)>>x<<1,x<<4);
    printf("%b", x);

// 6 (if else...)
    // int x;
    // scanf("%i", &x);
    // if (1 & x){
    //     printf("%s", "nechet");
    // }
    // else printf("%s", "chet");

//7
    // int x,y,z;
    // scanf("%i", &x);
    // scanf("%i", &y);
    // scanf("%i", &z);
    // if (y>x){
    //    x=y;
    // }
    // if (z>x){
    //     x=z;
    // }
    // printf("%i",x);


}
