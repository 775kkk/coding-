#include <stdio.h>
#include "../one.h"

// задача первая по сложению матриц
// #//////////////--------->

// #define ROW 3
// #define COL 3

// ф дл слож дв матр требукт предварительную инициализацию результирующего массива
void addMatrices(int** first, int* second, int result,int ROW, int COL) {
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
    int ROW,COL=3;
    int first[ROW][COL] = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
    int second[ROW][COL] = {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};
    int result[ROW][COL];

    // Сложение матриц
    addMatrices( first, &second, result);

    // Вывод результата
    printMatrix(result);
}