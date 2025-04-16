#include "stdio.h"
#include "malloc.h"
#include "string.h"
void fileCopy(char *file1, char* file2){                             // Функция для копирования символов файла одного в другой без добавления скрытных элементов
	char c;
	FILE * f1 = fopen(file1, "r");  		   	     // Открываю файлы для чтения и записи 
	FILE * f2 = fopen(file2, "w");   
    	if(f2){
    	while((c=getc(f1))!=EOF){				     // Циклом, пока не дойду до конца файла, считываю и переписываю символы
    		fprintf(f2, "%c", c);
		}
	}
    fclose(f1); 					             // Закрываю файлы
    fclose(f2);
}
void file_copy(char *file1, char* file2, char* arr){                 // Функция для копирования символов файла одного в другой с добавлением скрытных элементов
	char c;						
	int i = 0;					             // Счетчик для массива элементов	     
	FILE * f1 = fopen(file1, "r"); 
    	FILE * f2 = fopen(file2, "w");  
    	if(f2){
    	while((c=getc(f1))!=EOF){
    		if(c == '\n'){                                       // Если перенос на другую строку, то проверяю другие условия
    			if(arr[i] == '0'){			     // Если бит равен нулю, ничего не пишу и увеличиваю счётчик
				i++;
			}
			else if(arr[i] == '1'){			     // Если бит равен единице, то ставлю пробел и увеличиваю счётчик
				fprintf(f2, " ", arr[i]);
				i++;
				}
			}
    		fprintf(f2, "%c", c);	                             // Переписываю символ их первого файла
		}
	}
    fclose(f1); 						     // Закрываю файлы
    fclose(f2);
}
char* reverse(char* arr){	                                     // Функция для переворачивания массива символов 
	int len = strlen(arr)-1;
	char temp;
	for(int i = 0; i < len; i++){				  	
		temp = arr[i];
		arr[i] = arr[len];
		arr[len] = temp;
		len-=1;		
	}
}
void encode(char*file1, char*file2){                                 // Функция для зашифровки файла в другом файле путём разбиения на 8 бит 
	int num;						     // Число, которое будет переводиться в двоичную систему
	int flag = 0;						     // Флаг, для проверки выполнения функции
	char c;												
	char * file3 = "res.txt";                                    // Создаю файл, куда буду записывать данные в зашифрованном виде, а так же временный файл
	char * tmpFile = "tmp.txt";
	char* sym = (char*)malloc(9*sizeof(char));		     // Создаю динамический массива на 9 элементов(в двоичном представлении в числе будет максимум 8 символов), +1 с учётом конца строки	
	FILE * f1 = fopen(file1, "r");				     	
	FILE * f2 = fopen(file2, "r");                               // Открываю файлы для чтения и записи 
	FILE * f3 = fopen(file3, "w");
	FILE * ft = fopen(tmpFile, "w");
	if(f2){
		while((c = fgetc(f2))!=EOF){                         // Общий цикл по второму файлу
			for(int i = 0; i<8; i++){		     // Каждый раз обнуляю массив	
				sym[i] = '0';
			}
			sym[8] = '\0';                              
			num = c;
			for(int i = 0; num != 0; i++){		     // Перевожу число в двоичную систему исчисления
				sym[i] = (num%2) + '0';
				num/=2;
			}
			reverse(sym);				     // Переворачиваю число	
			if(f3 && flag == 0){
				file_copy(file1, file3, sym);        // Переписываю символы из первого файла в новый, с учётом зашифрованных элементов 
				flag = 1;
			}
			else{
				file_copy(file3, tmpFile, sym);      // Переписываю символы из нового файла во временный, с учётом зашифрованных элементов
				fileCopy(tmpFile, file3);	     // Перезаписываю обратно все символы из временного файла в новый	
					
			}
		}
	}
	fclose(f1);					
	fclose(f2);						     // Закрываю все файлы
	fclose(f3);
	fclose(ft);
	remove("tmp.txt");		                             // Удаляю временный файл
	free(sym);						     // Освобождаю память
}