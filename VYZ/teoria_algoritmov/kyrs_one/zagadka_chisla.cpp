#include "stdio.h"
#include "conio.h"
int main(){
	int a,b;
	scanf("%i%i", &a, &b);
	if (a >= b) {
        printf("Wrong range ; a must be less than b \n");
        return 1;
    }
	int mid = (a+b)/2;
	int isfind = 0;
	char userInput;
	while(a<=b){
		printf("is %i?\n", mid);
		userInput = getche();
		printf("\n");
		if (userInput == '='){
			printf("!!!");
			isfind = 1;
			break;
		}
		if (userInput == '<'){
			b = mid - 1;
		}
		else if (userInput == '>'){
			a = mid + 1;
		}
		mid = (a+b)/2;
	}
	if (isfind==0){
		printf("number not found");
	}
}
