#include <stdio.h>
#include <string.h>
#include <ctype.h>

int strLen(char* str){
    int i =0;
    for (; str[i]!='\0'; i++){}
    return i;
    
}
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
        if (nums(MainSpisok[i]))
        {
            Mage= Mage*10 + (MainSpisok[i]-'0');
            // printf("looool= %i Mage= %i\n ",i,Mage);
        }
        if (MainSpisok[i]==','||MainSpisok[i]=='\0')
        {
            // printf("Page %i;Mage %i;poz %i\n",Page,Mage,poz);
            if (Mage==0)
            {
                printf("eror age number at %i",i);
                break;
            }
            if ((Page<age)&&(age<Mage))
            {
                poz=Ppoz;
                break;
            }
            Page=Mage;
            Mage=0;
            Ppoz=i;
        }
    }
    int len= strLen(SubSpisok);
    SubSpisok[len]=',';
    SubSpisok[len+1]='\0';
    if (poz==0)
    {
        vstavkaVmass(MainSpisok,SubSpisok,poz);
    }
    else
    {
        vstavkaVmass(MainSpisok,SubSpisok,poz+1);
    }
}


int main(){
    char students[50] = "Nikitos 1 , Vanek 2, Valerka 10, Nastya 99";
    char dobavut[40] = "leksys 11";
    addStudents(students, dobavut);
    puts(students);  // Выведет результат

}
