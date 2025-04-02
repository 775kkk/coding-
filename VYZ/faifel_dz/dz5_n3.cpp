#include <stdio.h>
#include <malloc.h>

int strLen(char* str) {
    int i = 0;
    while (str[i] != '\0') {
        i++;
    }
    return i;
}

char* chisloTobaza(int chislo, int baza) {
    char* result = (char*)malloc((10 + 1)*sizeof(char));// 32 тк в самой мин системе, в двоичной этого хватит на 4 294 967 295 в десятичной системе
    // но нам этого много, поэтому переведем 1000 в двоичную систему получим 1111101000 , 10 символов достаточно будет
    int i = 0;
    if (baza<2 || baza>36) {
        return NULL;
    }
    while (chislo > 0) {
        int ostatok = chislo % baza;
        result[i++] = (ostatok<10) ? (ostatok+'0') : (ostatok-10+'A');
        chislo /= baza;
    }
    result[i] = '\0';// еще надо строку перевернуть но в нашей задаче это ну не надо
    return result;
}
bool polendromStr(char *str, int len){
    for (int i = 0; i < len/2; i++)
    {
        if (str[i]!=str[len-i-1])// последний символ = len-1 тк нумерация начинается с 0
        {
            return false;
        }
    }
    return true;
}
int zadachka(){
    int maxChislo=0;
    int maxResultMaxChisla=0;
    int mainResult;
    for (int i = 100; i < 1001; i++)// в условии [100,1000] != [100,1000)
    {
        mainResult=0;
        for (int j = 2; j < 37; j++)// [2,36] 
        {
            if (j>=10 && i%10==0)// если система>10 то 0 в конце явно делает число не полиндромом
            {
                continue;
            }
            if (i%j==0)// если число делится на систему то оно не может быть полиндромом
            {
                continue;
            }
            char* result = chisloTobaza(i, j);
            if (result == NULL) {
                continue;// врядли выйдет это исключение ну пусть будет
            }
            if (result[0]=='0')// если в конце 0 то это не полиндром, а число мы не переворачивали
            {
                free(result);
                continue;
            }// по идее так можно и дальше прописать сравнивая ifами числа в начале и конце но думаю на этом остановившись мы максимизируем эффективность
            if (polendromStr(result,strLen(result)))
            {
                mainResult++;
            }
            free(result);
        }
        if (mainResult>maxResultMaxChisla)
        {
            maxResultMaxChisla=mainResult;
            maxChislo=i;
        }
    }
    
    printf("%i ",maxChislo);
    printf("%i ",maxResultMaxChisla);
    return maxChislo;
}
int main() {
    int a = zadachka();// ответ 252 с результатом 6
}
