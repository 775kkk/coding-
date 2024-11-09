#include "stdio.h"

int main(){
	char a = 'a';
//	printf("%i",a);
	int FF = ("%i",a);
	char a1 = 'A';
	int FF2 = ("%i",a1);
//	printf("%i",a1);
//	printf("%c",("%i",a)-("%i", FFFF));

	printf("%c",("%i",a)-(("%i",FF)-("%i",FF2)));
	
}
