#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void printFIELD(char **field, int x, int y){
    printf("WWWW");
    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            printf("%c",field[y][x]);
        }
        printf("\n");
    }
    
}
char **generateField(int x, int y, int chanseWALL, int chansePOINT, int countPOINTS, int chanseSYNDYK, int countSYNDYKS,int countKEYS,int chanseKEY){
    int sumPOLE=x*y;
    char **mainField = (char**)malloc(y*sizeof(char*));
    for (int i = 0; i < y; i++)
    {
        mainField[y]=(char*)malloc(x*sizeof(char));
    }
    // расставляем всякое
    int synduksNOW=0;
    int keysNOW=0;
    int moneyNOW=0;
    int pointsNOW=0;
    int totalFREEmesta=0;
    // int personchanse=1;
    bool player=false;
    srand(time(0));
    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            if (rand()%101>chanseWALL)
            {
                // ДОРОГА
                if ((pointsNOW<=countPOINTS)&&(rand()%101<chansePOINT))
                {
                    //ПОИНТ
                    mainField[i][j]='*';
                    pointsNOW++;
                }else{
                    // mainField[i][j]='_';
                    // totalFREEmesta++;
                    //СПАВНИТЬ ПЕРСА СРАЗУ???? ок давай ->
                    if (!(player)&&(rand()%101<(chanseWALL/2)))//personchanse+totalFREEmesta*3
                    {
                        player=true;
                        mainField[i][j]='R';
                    }else{
                        mainField[i][j]='_';
                        totalFREEmesta++;
                    }
                    
                }
                
            }
            else{
                //СТЕНА
                if ((synduksNOW<=countSYNDYKS)&&(rand()%101<chanseSYNDYK))
                {
                    // сундук (проходимый)
                    mainField[i][j]='m';
                    synduksNOW++;
                }
                else if ((keysNOW<=countKEYS)&&(rand()%101<chanseKEY))
                {
                    // ключ (проходимый)
                    mainField[i][j]='p';
                    keysNOW++;
                }
                else
                {
                    mainField[i][j]='#';
                }   
            }
            printf("%c",mainField[i][j]);
        } 
        printf("\n");  
    }
    return mainField;
    
    
}
int main(){
    char **field=generateField(10,10,50,20,5,10,2,2,20);
    // printFIELD(field,10,10);
}