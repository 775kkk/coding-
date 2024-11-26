#include <stdio.h>
#include "../one.h"

// задача первая по сложению матриц
// #//////////////--------->

#define ROW 3
#define COL 3

// ф дл слож дв матр требукт предварительную инициализацию результирующего массива
void addMatrices(int first[ROW][COL], int second[ROW][COL], int result[ROW][COL]) {
    for (int i = 0; i < ROW; i++) {
        for (int j = 0; j < COL; j++) {
            result[i][j] = first[i][j] + second[i][j];
        }
    }
}


// ф дл выв матр
void printMatrix(int m[ROW][COL]) {
    for (int i = 0; i < ROW; i++) {
        for (int j = 0; j < COL; j++) {
            printf("%i ", m[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int first[ROW][COL] = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
    int second[ROW][COL] = {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};
    int result[ROW][COL];

    // Сложение матриц
    addMatrices(first, second, result);

    // Вывод результата
    printMatrix(result);

// #//////////////--------->
// 2
// задача вторая по построению змейки в матрице право лево право
// #//////////////--------->

    //2

    // const int N=3,M=3;
    // int zmei[N][M];
    // int k =1;
    // for (int i = 0; i < N; i++)
    // {
    //     if (i%2==0)
    //     {
    //         for (int j = 0; j < M; j++)
    //         {
    //         zmei[i][j]=k;
    //         k++;
    //         }
    //     }
    //     else
    //     {   k+=M-1;
    //         for (int j = 0; j < M; j++)
    //         {
    //         zmei[i][j]=k;
    //         k--;
    //         }
    //         k+=M+1;
    //     }
    // }
    // for (int i = 0; i < N; i++)
    // {
    //     for (int j = 0; j < M; j++)
    //     {
    //         printf("%i ",zmei[i][j]);
    //     }
    //     printf("\n");
    // }

// #//////////////--------->
// 3
// задача третья по нахождению колва вхождений
// #//////////////--------->

    // char str[100] = "ababa";
    // char str2[4] = "aba";
    // int count = 0;
    // for (int i = 0, j = 0; str[i]!='\0'; i++){
    //     if (str[i] == str2[0]){
    //         j = 0;
    //         for (;str2[j]!='\0'; j++){
    //             if (str[i+j] != str2[j]) break;
    //         }
    //   		if (str2[j] == '\0') count++;
    //     }
    // }
    // printf("%i",count);
    
// #//////////////--------->
// 4
// задача четвертая по нахождению индекса в массиве
// #//////////////--------->

    //4
    // int len = 6;
    // int arr[6]={1,2,5,6,10,22};
    // int iskom=1;
    // for (int i = 0; i < len; i++)
    // {
    //     if (arr[i]==iskom)
    //     {
    //         printf("%i",i);
    //         break;
    //     }
    //     else if (i==len-1)
    //     {
    //         printf("-1");
    //     }
    // }
    //получил автомат уже тут

// #//////////////--------->
// 5
// дана строка индекс и колво элементов удалить все элементы строки начиная с указанного индекса
// #//////////////--------->

// #//////////////--------->
// 6
// удалить все вхождения подстроки в строку
// #//////////////--------->


     
}

