#include "stdio.h"

int main(){
	int a = 5;
	int b = 3;
	float d = 1.0f;
	float c =a/b; // таким образом у нас только целая часть и то говно
	c =d*a/b; //а так вот ништяк
	c =(float)a/b;//тоже ништяк
	printf("%e", c);
	
	a = 0;
	b = 333;
	printf("%s", a && b ? "Fff" : "bebe");
	
}
