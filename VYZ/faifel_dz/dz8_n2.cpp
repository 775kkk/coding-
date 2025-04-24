#include <stdio.h>
#include <stdlib.h>

ssize_t search_in_file(const char *filename, int N) {// ret -1 0 и положительные
    FILE *file = fopen(filename, "r");
    if (file == NULL){
        printf("eror\n");
        return -1;
    }
    
    int num;
    while (fscanf(file, "%d", &num) == 1){
        if (num == N){
            fclose(file);
            return 1;
        }
        if (num > N){
            break;//так как числа упорядочены
        }
    }
    fclose(file);
    return 0;
}

int main() {
    const char *filename = "numbers.txt";
    int N;
    int result = search_in_file(filename, N);
    
}