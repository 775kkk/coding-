#include <stdio.h>
#include <string.h>
#include <ctype.h>

int strLen(char* str){
    int i =0;
    for (; str[i]!='\0'; i++){}
    return i;
    
}
// =================
// 1 
void maxSumElementsM(int* arr, int row, int col) {
    int max= 0;
    int point = 0;

    for (int i = 0; i < col; i++) {
        int sum = 0;
        for (int j = 0; j < row; j++) {
            sum += arr[j * col + i]; // Правильный доступ к элементам
        }
        if (sum > max) {
            max = sum;
            point = i;
        }
    }
}
// =================
// 2
void removeMaxWord(char* str){
    int lenM=strLen(str);
    int pLen=0;
    int maxLen=0;
    int point =0;
     for(int i=0;str[i] != '\0';i++){//детектед^3535$2424
        if (isalnum(str[i])) {
            pLen++;
        } else {
            if (pLen > maxLen) {
                maxLen = pLen;
                point = i - pLen;
            }
            pLen = 0; 
        }
     }
     //обработка последнего слова
    if (pLen>maxLen)
    {
        str[lenM-pLen]='\0';
    }else{
        //удаляем
        int i = point + maxLen;
        while (i <= lenM) {
        str[point++] = str[i++];
        }
    }
}
// =================
// 3

bool nums(char symbol){
    char spisok[11]="0123456789";
    for (int i = 0; spisok[i]!='\0'; i++)
    {
        if (symbol==spisok[i])
        {
            return true;
        }
    }
}
void vstavkaVmass(char* strMain,char* strSub,int poz){
    int lenMain=strLen(strMain);
    int lenSub=strLen(strSub);
    int j=lenSub-1;
    for (int i = lenMain+lenSub; i>=poz; i--)
    {
        if (i>=lenSub+poz)
        {
            strMain[i]=strMain[i-lenSub];
        }
        else
        {
            strMain[i]=strSub[j];
            j--;
        }   
    }
}
void vstavkaVmass(char* strMain,char Sub,int poz){
    int lenMain=strLen(strMain);
    int lenSub=1;
    int j=lenSub-1;
    for (int i = lenMain+lenSub; i>=poz; i--)
    {
        if (i>=lenSub+poz)
        {
            strMain[i]=strMain[i-lenSub];
        }
        else
        {
            strMain[i]=Sub;
            j--;
        }   
    }
}
void addStudents(char* MainSpisok, char* SubSpisok){
    
    int age = 0;//найдем возраст чела
    bool point =false;
    for (int i = 0; SubSpisok[i]!='\0'; i++)
    {
        if (nums(SubSpisok[i]))
        {
            age=age*10+(SubSpisok[i]-'0');
        }
    }
    //определимся куда его вставлять
    // printf("age %i\n", age);
    int poz=0;
    int Mage=0;
    int Page=0;
    int Ppoz=0;
    for (int i = 0;i!=strLen(MainSpisok)+1; i++)
    {
        if (nums(MainSpisok[i])) // СЧИТАЕМ ВОЗРАСТ У СЕГМЕНТА
        {
            Mage= Mage*10 + (MainSpisok[i]-'0');
            // printf("looool= %i Mage= %i\n ",i,Mage);
        }
        if (MainSpisok[i]==','||MainSpisok[i]=='\0') // КОНЧАЕТСЯ СЕГМЕНТ ПОДВОДИМ ЕГО ИТОГИ
        {
            // printf("Page %i;Mage %i;poz %i\n",Page,Mage,poz);
            if (Mage==0)
            {
                printf("eror age number at %i",i);
                break;
            }
            if ((Page<age)&&(age<Mage)) // ОБРАБОТКА ЕСЛИ В СЕРЕДИНУ ПРЕДПОЛАГАЕТСЯ ВСТАВКА
            {
                poz=Ppoz;
                break;
            }
            else if (age<Mage)// ЕСЛИ В НАЧАЛЕ
            {
                poz=Ppoz;
                break;
            }
            
            Page=Mage;
            Mage=0;
            Ppoz=i;
        }
        if (MainSpisok[i]=='\0') // ОБРАБОТКА ЕСЛИ ВТАВЛЯЕМ В КОНЕЦ
        {
            if ((Mage<age))
            {
                poz=i;
                break;
            }
        }
    }
    //ВСТАВЛЯЕМ
    // printf("poz %i",poz);
    if (poz==0)//ЕСЛИ В НАЧАЛЕ
    {
        int len= strLen(SubSpisok);
        SubSpisok[len]=',';
        SubSpisok[len+1]='\0';
        vstavkaVmass(MainSpisok,SubSpisok,poz);
    }
    if (poz>=strLen(MainSpisok)) //ЕСЛИ В КОНЦЕ
    {   
        vstavkaVmass(SubSpisok,' ',0);
        vstavkaVmass(SubSpisok,',',0);
        vstavkaVmass(MainSpisok,SubSpisok,poz);
    }
    else // ЕСЛИ ОБЫЧНО (СЕРЕДИНА)
    {
        int len= strLen(SubSpisok);
        vstavkaVmass(SubSpisok,' ',0);
        vstavkaVmass(SubSpisok,',',len+1);
        vstavkaVmass(MainSpisok,SubSpisok,poz+1);
    }
}

int main() {
// =================
// 1.	Дана матрица чисел, вывести элементы столбца, у которого сумма элементов наибольшая 
    // int row = 5;
    // int col = 5;
    // int arr[row][col] = {{1, 2, 3, 4, 5},{6, 7, 8, 9, 10},{11, 12, 13, 14, 15},{16, 17, 18, 19, 20},{21, 22, 23, 24, 25}};
    // maxSumElementsM(&arr[0][0], row, col); // Передаем указатель на первый элемент
// =================
// 2. Дана строка как массив символов, удалить слово наибольшей длины. Разделителем слов считать любые символы отличные от букв и цифр.
    // char str[32]="1133!1111111(22%2";
    // removeMaxWord(str);
    // puts(str);
    // char str2[100] = "This is a test string with some 111111111111111 words.";
    // removeMaxWord(str2);
    // puts(str2);
// =================
// 3. Дана строка как массив символов, в ней записаны студенты и их возраст в порядке возрастания возраста. 
//    Необходимо добавить в исходную строку ещё одного студента с заданным возрастом, не нарушив возрастающую последовательность.
    char students[50]="Nikitos 1 , Vanek 2, Valerka 10, Nastya 18";
    char dobavut[40]="leksys 19";
    addStudents(students,dobavut);
    puts(students);

}