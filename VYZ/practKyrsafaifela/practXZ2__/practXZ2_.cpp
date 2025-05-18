#include <stdio.h>
#include <stdlib.h>


// задача 1 {
// отсортировать много разных в один
// вх массив миссивов ,массив длин массивов, колво массивов(длина arrays)
int *refragirators(int **arrays,const int *sizes, int n) {
    int resultSize = 0;
    for (int i = 0; i < n; i++) {
        resultSize += sizes[i];
    }
    int *result = (int *)malloc(resultSize * sizeof(int));
    int *indexs = (int *)calloc(n, sizeof(int));
    int *temps = (int *)malloc(n * sizeof(int));
    int resultIndex = 0;
    for (; resultIndex < resultSize;)// РАБОТАЕТ ТОЛЬКО ПРИ УСЛОВИИ ЧТО МАССИВЫ УЖЕ ОТСОРТИРОВАНЫ
    {
        for (int i = 0; i < n; i++)
        {
            temps[i] = arrays[i][indexs[i]];
        }
        for (int i = 0; i < n; i++)
        {
            if (indexs[i] >= sizes[i])// если индекс вышел за пределы массива
            {
                temps[i] = INT_MAX;
            }
        }
        int min=INT_MAX-1;
        int minIndex=0;
        for (int i = 0; i < n; i++)
        {
            if (temps[i] < min)
            {
                min = temps[i];
                minIndex = i;
            }          
        }
        indexs[minIndex]++;
        result[resultIndex++] = min;
    }
    free(indexs);
    free(temps);
    return result;
}
    // задача 1\>
    // задача 2

    // считывает размер файла
    ssize_t takeSize(char *name) {
        FILE *file = fopen(name, "r");
        if (file == NULL) {
            printf("error openning file %s\n", name);
            return -1;
        }
        int size = 0;
        int temp;
        while (fscanf(file, "%d", &temp) == 1) {
            size++;
        }
        fclose(file);
        return size;
    }
    // берем данные
    int * takeData(char *name, int size) {
        FILE *file = fopen(name, "r");
        if (file == NULL) {
            printf("error openning file %s\n", name);
            return NULL;
        }
        int *data = (int *)malloc(size * sizeof(int));
        for (int i = 0; i < size; i++) {
            fscanf(file, "%d", &data[i]);
        }
        fclose(file);
        return data;
    }

// Функция для слияния двух отсортированных подмассивов в один
void merge(int *arr, int left, int mid, int right) {
    int n1 = mid - left + 1; // размер левого
    int n2 = right - mid;    // размер правого
    // temp массивы
    int *L = (int *)malloc(n1 * sizeof(int));
    int *R = (int *)malloc(n2 * sizeof(int));
    // копируем в временные
    for (int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];
    // индексы для прохода
    int i = 0, j = 0, k = left;
    // сливаем временные массивы обратно в arr
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k++] = L[i++];
        } else {
            arr[k++] = R[j++];
        }
    }
    // копируем оставшиеся 
    while (i < n1) {
        arr[k++] = L[i++];
    }
    while (j < n2) {
        arr[k++] = R[j++];
    }
    free(L);
    free(R);
}

// сливаем
void mergeSort(int *arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2; // середина массива

        // Сортируем первую и вторую половины
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Сливаем отсортированные половины
        merge(arr, left, mid, right);
    }
}
// задача 3\>
    // задача 4
    void writeArrayToFile(const char *filename, const char *arrName, int *arr, int size) {
    FILE *f = fopen(filename, "a");
    if (!f) return;
    fprintf(f, "%s: ", arrName);
    for (int i = 0; i < size; i++) {
        fprintf(f, "%d ", arr[i]);
    }
    fprintf(f, "\n");
    fclose(f);
    }
    // слияние трех массивов
    void merge3(int *arr, int left, int mid1, int mid2, int right, const char *filename) {
    int n1 = mid1 - left + 1;
    int n2 = mid2 - mid1;
    int n3 = right - mid2 + 1;

    int *L = (int *)malloc(n1 * sizeof(int));
    int *M = (int *)malloc(n2 * sizeof(int));
    int *R = (int *)malloc(n3 * sizeof(int));

    for (int i = 0; i < n1; i++) L[i] = arr[left + i];
    for (int i = 0; i < n2; i++) M[i] = arr[mid1 + 1 + i];
    for (int i = 0; i < n3; i++) R[i] = arr[mid2 + 1 + i];

    // записываем 
    writeArrayToFile(filename, "L", L, n1);
    writeArrayToFile(filename, "M", M, n2);
    writeArrayToFile(filename, "R", R, n3);

    // соединяем
    int i = 0, j = 0, k = 0, t = left;
    while (i < n1 && j < n2 && k < n3) {// сливаем все три оч мешанина сам уже запутался но работает
        if (L[i] <= M[j] && L[i] <= R[k]) arr[t++] = L[i++];
        else if (M[j] <= L[i] && M[j] <= R[k]) arr[t++] = M[j++];
        else arr[t++] = R[k++];
    }
    while (i < n1 && j < n2) {
        if (L[i] <= M[j]) arr[t++] = L[i++];
        else arr[t++] = M[j++];
    }
    while (i < n1 && k < n3) {
        if (L[i] <= R[k]) arr[t++] = L[i++];
        else arr[t++] = R[k++];
    }
    while (j < n2 && k < n3) {
        if (M[j] <= R[k]) arr[t++] = M[j++];
        else arr[t++] = R[k++];
    }
    while (i < n1) arr[t++] = L[i++];
    while (j < n2) arr[t++] = M[j++];
    while (k < n3) arr[t++] = R[k++];

    free(L);
    free(M);
    free(R);
}

// трешная сортировка слиянием
void mergeSort3(int *arr, int left, int right, const char *filename) {
    if (left < right) {
        int len = right - left + 1;
        int third = len / 3;
        int rem = len % 3;
        int mid1 = left + third - 1 + (rem > 0 ? 1 : 0);
        int mid2 = mid1 + third + (rem > 1 ? 1 : 0);

        if (mid1 >= right) mid1 = left + (right - left) / 3;
        if (mid2 >= right) mid2 = left + 2 * (right - left) / 3 + 1;

        mergeSort3(arr, left, mid1, filename);
        mergeSort3(arr, mid1 + 1, mid2, filename);
        mergeSort3(arr, mid2 + 1, right, filename);

        merge3(arr, left, mid1, mid2, right, filename);
    }
}



int main(){
    // задача 1
    printf("zadacha 1\n");
    int n = 5;
    int sizes[] = {4, 3, 5,10,1};
    int *arrays[n];// массив указателей на массивы
    arrays[0] = (int *)malloc(4 * sizeof(int));
    arrays[1] = (int *)malloc(3 * sizeof(int));
    arrays[2] = (int *)malloc(5 * sizeof(int));
    arrays[3] = (int *)malloc(10 * sizeof(int));
    arrays[4] = (int *)malloc(1 * sizeof(int));

    // zаполняем
    for (int i = 0; i < sizes[0]; i++) {
        arrays[0][i] = i + 2;
    }
    for (int i = 0; i < sizes[1]; i++) {
        arrays[1][i] = i + 5;
    }
    for (int i = 0; i < sizes[2]; i++) {
        arrays[2][i] = i + 13;
    }
    for (int i = 0; i < sizes[3]; i++) {
        arrays[3][i] = i + 20;
    }
    for (int i = 0; i < sizes[4]; i++) {
        arrays[4][i] = i + 30;
    }
    // выводим
    printf("data :\n");
    for (int i = 0; i < n; i++) {
        printf("array %d : ", i);
        for (int j = 0; j < sizes[i]; j++) {
            printf("%d ", arrays[i][j]);
        }
        printf("\n");
    }
    int *yeu = refragirators(arrays, sizes,n);
    printf("otsortirovale :\n");
    for (int i = 0; i < sizes[0] + sizes[1] + sizes[2]+sizes[3]+sizes[4]; i++) {// тут не забудь про n массивов
        printf(" %d",yeu[i]);
    }

    free(yeu);
    for (int i = 0; i < n; i++)
    {
        free(arrays[i]);
    }
    // задача 1\>
    // задача 2
    printf("\n\nzadacha 2\n");
    int nT2 = 4;// колво файлов
    int *arraysT2[nT2];
    int sizesT2[nT2];
    char names[nT2][20] = {"for_ptactXZ2_1.txt", "for_ptactXZ2_2.txt", "for_ptactXZ2_3.txt", "for_ptactXZ2_4.txt"};
    for (int i = 0; i < nT2; i++)
    {
        sizesT2[i] = takeSize(names[i]);
        arraysT2[i] = takeData(names[i], sizesT2[i]);
    }
    printf("data :\n");
    for (int i = 0; i < nT2; i++) {
        printf("array %d : ", i);
        for (int j = 0; j < sizesT2[i]; j++) {
            printf("%d ", arraysT2[i][j]);
        }
        printf("\n");
    }
    int *yeuT2 = refragirators(arraysT2, sizesT2,nT2);
    printf("\notsortirovale :\n");
    for (int i = 0; i < sizesT2[0] + sizesT2[1] + sizesT2[2]+sizesT2[3]; i++) {// тут не забудь про n массивов
        printf(" %d",yeuT2[i]);
    }

    free(yeuT2);
    for (int i = 0; i < nT2; i++)
    {
        free(arraysT2[i]);
    }
    // задача 2\>
    // задача 3
    printf("\n\nzadacha 3\n");
    int size = 5;
    int *data = (int *)malloc(size * sizeof(int));
    data[0] = 5;
    data[1] = 3;
    data[2] = 1;
    data[3] = 4;
    data[4] = 2;
    printf("data :\n");
    for (int i = 0; i < size; i++) {
        printf("%d ", data[i]);
    }
    printf("\n");
    mergeSort(data, 0, size - 1);
    printf("otsortirovale :\n");
    for (int i = 0; i < size; i++) {
        printf("%d ", data[i]);
    }
    printf("\n");
    free(data);
    // задача 3\>
    // задача 4
    printf("\n\nzadacha 4\n");
    int sizeT4 = 10;
    int *dataT4 = (int *)malloc(sizeT4 * sizeof(int));
    dataT4[0] = 5;
    dataT4[1] = 3;
    dataT4[2] = 1;
    dataT4[3] = 4;
    dataT4[4] = 2;
    dataT4[5] = 8;

    dataT4[6] = 7;
    dataT4[7] = 6;

    dataT4[8] = 10;
    dataT4[9] = 9;
    printf("data :\n");
    for (int i = 0; i < sizeT4; i++) {
        printf("%d ", dataT4[i]);
    }
    printf("\n");
    FILE *f = fopen("LRM.txt", "w");
    if (f) fclose(f);
    mergeSort3(dataT4, 0, sizeT4 - 1, "LRM.txt");
    printf("otsortirovale :\n");
    for (int i = 0; i < sizeT4; i++) {
        printf("%d ", dataT4[i]);
    }

}