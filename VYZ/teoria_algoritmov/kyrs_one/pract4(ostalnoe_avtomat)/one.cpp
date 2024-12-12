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

void addStudents(char* spisokMain,char* spisokSecond){
    int nameStrt = 0;
    int  nameLen = 0;
    // нужно найти число лет
    for (int i = 0; i <= strLen(spisokSecond); i++)// avbek 32,
    {
        if (isalnum(spisokSecond[i]) && i!=0)
        {
            if (nameStrt==i-nameLen)
            {
                nameLen++;
            }
            else if (!(isalpha(spisokSecond[i-1])))
            {
                nameStrt=i;
                nameLen++;
            }  
        }
    }
    int age=0;
    for (int i = 0; i < nameLen; i++)
    {
        age=age*10 + (spisokSecond[nameStrt+i] - '0');
    }
    // нужно найти куда вставлять
    int poz=0;
    int perVname=0;
    int ageM=0;
    int perVage=0;
    int perVpoz=0;
    bool point=0;
    for (int i = 0; i < strLen(spisokMain); i++)
    {
        if (isalnum(spisokMain[i])&& point)
        {
            ageM= ageM*10 + (spisokMain[i]-'0');
        }
        // if (isalnum(spisokMain[i]) && (i == 0 || !isalnum(spisokMain[i - 1])))// avbek 32,
        // {   
        //     if (nameStrt==i-nameLen)
        //     {
        //         nameLen++;
        //     }
        //     else if (!(isalpha(spisokMain[i-1])))
        //     {
        //         nameStrt=i;
        //         nameLen++;
        //     }
        // }
        if(spisokMain[i]==',' || spisokMain[i] == '\0'){
            if (ageM > 0 && ((perVage < age) && (age < ageM)))
            {
                poz=perVpoz;
                break;
            }
            perVpoz=i+1;
            perVage=ageM;
            ageM=0;
            point=0;
        }
        if (spisokMain[i]==' ')
        {
            point=1;
        }
        
        // if (spisokMain[i]==',' || spisokMain[i] == '\0')
        // {
        //     for (int j = 0; j < nameLen; j++)
        //     {
        //      ageM=ageM*10 +(spisokMain[nameStrt+j] - '0');
        //     }
        //     if ((perVage<age) && (age<ageM))
        //     {
        //         poz=perVpoz;
        //         break;
        //     }
        //     perVpoz=i+1;
        //     perVage=ageM;
        //     ageM=0;
        //     nameLen=0;
        //     nameStrt=0;
        // }  
    }
    int sssssss= strLen(spisokSecond);
    spisokSecond[sssssss]=',';
    spisokSecond[sssssss+1]='\0';
    vstavkaVmass(spisokMain,spisokSecond,poz);

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
    char students[50]="Nikitos 1 , Vanek 2, Valerka 10, Nastya 99";
    char dobavut[40]="leksys 466";
    addStudents(students,dobavut);
    puts(students);

}
