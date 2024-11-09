#include "stdio.h"
int main(){
	printf("%i", sizeof(float));
	printf("%i", sizeof(short));
	printf("%i", sizeof(long));
	printf("%i", sizeof(int));	
	
	for (int t=0;t<20,t+=2){
		printf("%i",t);
	}
}
