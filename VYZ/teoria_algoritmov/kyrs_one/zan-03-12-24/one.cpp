#include "stdio.h"

bool ravenstvoStrok(char* str1, char* str2){
    for (int i = 0; (*(str1+i)!='\0')||(*(str2+i)!='\0'); i++)
    { // "*(str2+i)" can replase -> "str1[i]" or "str2[i]"
        if (*(str1+i)!=*(str2+i))
        {
            return not(true);
        }
        return true;
    }
}
int strLen(char* str){
    for (int i = 0; true; i++)
    {
        if (str[i]=='\0')
        {
          return i;
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

int main(){
    // int a = 5;
    // int* sptr = &a;
    // int b = 3;
    // int* bptr = &b;
    // printf("%p \n %i \n %p \n %i \n", sptr,*sptr,bptr,*bptr);
    // // � ����� ��� ����� ������� �������� � ���� ������� ������
    // // л валью это штука которая содержит в себе локатор памяти а р валью это переменная которая тоже содержит в себе локатор памяти

    // char str[100] = "abcd";
    // char* strptr = str;
    // for (int i = 0; strptr[i]!='\0'; i++)
    // {
    //     printf("%c\n", strptr[i]);
    // }
    // printf("\n bebebe \n");
    // for (int i = 0; *(strptr+i)!='\0'; i++)
    // {
    //     printf("%c\n", *(strptr+i));
    // }
    // char str[100]="bebebekba";
    // char str1[100]="bebebekba";
    // if (ravenstvoStrok(str,str1))
    // {
    //     printf("krasavcheeeek");
    //     printf("\n%i",strLen(str));
    // }
    char str[100]="bebebe";
    char str1[100]="kba";
    int kbaI=4;
    vstavkaVmass(str,str1,kbaI);
    puts(str);
    
}
