#include "stdio.h"

int main(){
	int a = 5;
	int b = 3;
	float d = 1.0f;
	float c =a/b; // ����� ������� � ��� ������ ����� ����� � �� �����
	c =d*a/b; //� ��� ��� ������
	c =(float)a/b;//���� ������
	printf("%e", c);
	
	a = 0;
	b = 333;
	printf("%s", a && b ? "Fff" : "bebe");
	
}
