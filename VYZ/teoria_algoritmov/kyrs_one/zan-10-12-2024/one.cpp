#include <stdio.h>
#include <string.h>
#include <malloc.h>

char* s_vstavka(char* str, char* substr, int poz){
    int lenMain= strlen(str);
    int lenSub= strlen(substr);
    char* result = (char*)calloc(lenMain+lenSub,sizeof(char));
    int j=lenSub-1;
    for (int i = lenMain+lenSub; i>=poz; i--)
    {
        if (i>=lenSub+poz)
        {
            result[i]=str[i-lenSub];
        }
        else
        {
            result[i]=substr[j];
            j--;
        }   
    }

    return result;
}

int main() {
    char str[33]="aaaa0";
    char str2[33]="FFFFFF";
    char *strr =s_vstavka(str,str2,4);
    puts(strr);
}