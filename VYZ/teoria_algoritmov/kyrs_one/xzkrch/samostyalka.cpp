#include "stdio.h";

int main(){

// 1
//     int x;
//     scanf("%i", &x);
//     int y;
//     scanf("%i", &y);
//     printf("%i", x>>(y-1));

// 2
//     int x;
//     scanf("%i", &x);
//     printf("%i", (x>>2) & x ? 1 : 0);

// 3
     int x;
     scanf("%i", &x); 
     printf("%x",x&8,x&1,x&2,x&4);// x*1000,x*1,x*10,x*100 

    for (size_t i = 0; i < count; i++)
    {
        /* code */
    }
    
// 1 (if else)
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

// 2 (if else)
//     int x,y,z;
//     scanf("%i", &x);
//     scanf("%i", &y);
//     scanf("%i", &z);
//     if (x==y && y==z)
//     {
//         printf("%s", "ravnbl");
//     }else{
//     	printf("%s", "ne ravnbl");
//	 }
    
// 3
    // int A,B,C,D;
//     scanf("%i", &A);
//     scanf("%i", &B);
//     scanf("%i", &C);
//     scanf("%i", &D);
//     printf("%i", D>B ? (A+((D-B)*C)) : A);


}
