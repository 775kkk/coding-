#include "stdio.h";

int main(){
    int a;
    int b;
    scanf("%i", &a);
    scanf("%i", &b); 
	// scanf("%d", &a);
    printf("%i", a > b ? a : b);
    printf("%s", a%2==0 ? "a четное" : "а не четное");
    printf("%s", b%2==0 ? "b четное" : "b не четное");


}