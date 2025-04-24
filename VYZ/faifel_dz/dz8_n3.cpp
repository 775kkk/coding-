#include <stdio.h>
#include <stdlib.h>

typedef struct Stack {
    int top;
    unsigned capacity;
    int* array;
} Stack;

Stack* createStack(unsigned capacity) {
    Stack* stack = (Stack*)malloc(sizeof(Stack));
    stack->capacity = capacity;
    stack->top = -1;
    stack->array = (int*)malloc(stack->capacity * sizeof(int));
    return stack;
}

int isFull(Stack* stack) {// полный?
    return stack->top == stack->capacity - 1;
}

int isEmpty(Stack* stack) {// пустой?
    return stack->top == -1;
}

void push(Stack* stack, int item) {// добавить (если есть место)
    if (isFull(stack)) return;
    stack->array[++stack->top] = item;
}

int pop(Stack* stack) {// удалить (если есть что удалять)
    if (isEmpty(stack)) return -1;
    return stack->array[stack->top--];
}

int peek(Stack* stack) {// посмотреть чо там
    if (isEmpty(stack)) return -1;
    return stack->array[stack->top];
}

void sortStack(Stack *s1, Stack *s2, Stack *s3, int ascending) {
    while (!isEmpty(s1)) {// перемещаем все элементы из s1 в s2
        push(s2, pop(s1));
    }
    while (!isEmpty(s2)) {// перемещаем все элементы из s2 в s3 с сортировкой
        int temp = pop(s2);
        
        if (ascending) {
            // сортировка по возрастанию
            while (!isEmpty(s3) && peek(s3) < temp) {
                push(s2, pop(s3));
            }
        } else {
            // сортировка по убыванию
            while (!isEmpty(s3) && peek(s3) > temp) {
                push(s2, pop(s3));
            }
        }
        
        push(s3, temp);
    }
    
    // переносим отсортированные элементы обратно в s1
    while (!isEmpty(s3)) {
        push(s1, pop(s3));
    }
}

int main() {
    Stack *s1 = createStack(100);
    Stack *s2 = createStack(100);
    Stack *s3 = createStack(100);
    
    push(s1, 34);
    push(s1, 3);
    push(s1, 31);
    push(s1, 98);
    push(s1, 92);
    push(s1, 23);
    
    printf("baze stac 1:\n");
    for (int i = 0; i <= s1->top; i++) {
        printf("%d ", s1->array[i]);
    }
    printf("\n");
    
    // cортируем по возрастанию 1 или по убыванию 0
    sortStack(s1, s2, s3, 1);
    
    printf("sorted stac 1\n");
    for (int i = 0; i <= s1->top; i++) {
        printf("%d ", s1->array[i]);
    }
    printf("\n");
    
    free(s1->array);
    free(s2->array);
    free(s3->array);
    free(s1);
    free(s2);
    free(s3);
}