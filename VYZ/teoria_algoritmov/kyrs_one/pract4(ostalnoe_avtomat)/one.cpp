#include <stdio.h>

void maxSumElements(int* arr, int row, int col) {
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

//    printf("Столбец с максимальной суммой элементов (%d):\n", maxColIndex);
    for (int i = 0; i < row; i++) {
        printf("%i ", arr[i * col + point]); // Правильный доступ к элементам
    }
    printf("\n");
}

int main() {
// 1
    int row = 5;
    int col = 5;
    int arr[row][col] = {{1, 2, 3, 4, 5},{6, 7, 8, 9, 10},{11, 12, 13, 14, 15},{16, 17, 18, 19, 20},{21, 22, 23, 24, 25}};
    maxSumElements(&arr[0][0], row, col); // Передаем указатель на первый элемент
//========
//2

}
