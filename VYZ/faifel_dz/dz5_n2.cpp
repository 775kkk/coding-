#include <stdio.h>
#include <malloc.h>

bool fibonachi(int n) {
    if (n == 0 || n == 1) return true;
    int a = 0;
    int b = 1;
    int temp=0;
    while (b < n) {
        temp = a + b;
        a = b;
        b = temp;
    }
    return b == n;
}
int main() {
    int n=8;
    printf("%d", fibonachi(n));
}
