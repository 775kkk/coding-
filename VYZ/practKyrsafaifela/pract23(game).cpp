#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MIN(i, j) (((i) < (j)) ? (i) : (j))
#define MAX(i, j) (((i) > (j)) ? (i) : (j))

void printFIELD(char **field, int x, int y){
    for (int i = 0; i < y; i++)
    {
        for (int j = 0; j < x; j++)
        {
            printf("%c",field[i][j]);
        }
        printf("\n");
    }
    
}
char **generateField(int x, int y, int chanseWALL, int chansePOINT, int countPOINTS, int chanseSYNDYK, int countSYNDYKS,int countKEYS,int chanseKEY, int *plCords){
    int sumPOLE=x*y;
    char **mainField = (char**)malloc(y*sizeof(char*));
    for (int i = 0; i < y; i++)
    {
        mainField[i]=(char*)malloc(x*sizeof(char));
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
                        mainField[i][j]='_';
                        totalFREEmesta++;
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
            // printf("%c",mainField[i][j]);
        } 
        // printf("\n");  
    }
    plCords[0]=rand()%y;
    plCords[1]=rand()%x;
    mainField[plCords[0]][plCords[1]]='R';
    return mainField;
}

int calculatePotentialPoints(char **field, int x, int y, int plX, int plY){
    if (plX < 0 || plX >= y || plY < 0 || plY >= x) return 0;

    // Массив для отметки посещённых клеток
    bool **visited = (bool**)malloc(y * sizeof(bool*));
    for (int i = 0; i < y; i++) {
        visited[i] = (bool*)malloc(x * sizeof(bool));
        for (int j = 0; j < x; j++) visited[i][j] = false;
    }

    // Очередь на массиве (максимум x*y элементов)
    int *queueX = (int*)malloc(x * y * sizeof(int));
    int *queueY = (int*)malloc(x * y * sizeof(int));
    int head = 0, tail = 0;

    // Начальная позиция
    queueX[tail] = plX;
    queueY[tail] = plY;
    tail++;
    visited[plX][plY] = true;

    int points = 0, chests = 0, keys = 0;
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    while (head < tail) {
        int curX = queueX[head];
        int curY = queueY[head];
        head++;

        // Обработка клетки
        char cell = field[curX][curY];
        printf("Visited (%d, %d): %c\n", curX, curY, cell);
        if (cell == '*') points++;
        else if (cell == 'm') chests++;
        else if (cell == 'p') keys++;

        // Добавление соседей
        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];
            if (nx >= 0 && nx < y && ny >= 0 && ny < x && !visited[nx][ny]) {
                char neighbor = field[nx][ny];
                if (neighbor == '#') {
                    printf("Blocked at (%d, %d)\n", nx, ny);
                }
               if (neighbor == '_' || neighbor == '*' || neighbor == 'm' || neighbor == 'p' || neighbor == 'R') {
                    visited[nx][ny] = true;
                    queueX[tail] = nx;
                    queueY[tail] = ny;
                    tail++;
                }
            }
        }
    }

    // Освобождение памяти
    for (int i = 0; i < y; i++) free(visited[i]);
    free(visited);
    free(queueX);
    free(queueY);
    
    return points + 4*MIN(chests,keys);
}

// _###___###
// #__#_#*#p#
// p#__##m_pR
// ##_##_##*_
// #_##_m___#
// #m###__#_#
// _#_#_#*###
// #_#__####_
// #***##_##_
// _#_#___##_

// __#_p##__m
// ##_____###
// _##_p##_##
// #**p#_m#*_
// ###__#_#*#
// _#____#__*
// _m*_#_#___
// #_###_##_#
// #_#___#___
// #_R#_#_#_#

// по какойто причине 1 а должно быть 2
// m#m___*m##
// #__#p###_#
// _########p
// ###_*##_##
// ###_#_#___
// *_#_R_*p__
// _####_####
// #__#*#___#
// #*___#####
// _#_##__#_#
// 1

// ##_*___##m
// #_#***##*_
// _m_#__p_#_
// ____p_###_
// __#p#_#*__
// _#_m__###_
// _#_#######
// _#R##_##_#
// _#___####_
// ___##__###
// 12
int main(){
    int *playerCoords = (int*)malloc(2*sizeof(int));
    char **field=generateField(10,10,50,20,5,10,2,2,20,playerCoords);
    printf("\n");
    printFIELD(field,10,10);


    int res= calculatePotentialPoints(field,10,10,playerCoords[1],playerCoords[0]);
    printf("%i",res);
    for (int i = 0; i < 10; i++) {
        free(field[i]);
    }
    free(field);
}