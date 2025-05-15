#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define STACK_SIZE 100
#define PROGRAM_SIZE 100

typedef struct {
    int stack[STACK_SIZE];
    int top;  // вершина стека
    int R1, R2;  // регистры
    char *program[PROGRAM_SIZE];  // массив команд
    int pc;  // счётчик команд
} StackMachine;

typedef struct {// MARK
    char name[20];
    int pc;
    int repeat;
} marks;

marks mark[10];
int mark_count = 0;
int return_stack[100];  // return
int return_top = 0;

void push(StackMachine *sm, int value) {
    if (sm->top >= STACK_SIZE) {
        printf("stack overflow!\n");
        return ;
    }
    sm->stack[sm->top++] = value;
}

int pop(StackMachine *sm) {
    if (sm->top <= 0) {
        printf("stack underflow!\n");
        return 0;
    }
    return sm->stack[--sm->top];
}

void execute(StackMachine *sm, const char *command) {
    // printf("[debug] before: cmd=%s, stack_top=%d, R1=%d, R2=%d\n", command, sm->top, sm->R1, sm->R2);
//======================== дополнительные команды ==========================
    if (strcmp(command, "help") == 0) {// HELP
        printf("Available commands (45):\n");
        printf("help - Show available commands\n");
        printf("set R1 <value> - Set register R1 to <value>\n");
        printf("set R2 <value> - Set register R2 to <value>\n");
        printf("push <value>   - Push value onto stack\n");
        printf("push R1        - Push value of R1 onto stack\n");
        printf("push R2        - Push value of R2 onto stack\n");
        printf("pop R1         - Pop value from stack to R1\n");
        printf("pop R2         - Pop value from stack to R2\n");
        printf("add            - Add top two values on stack\n");
        printf("sub            - Subtract top two values on stack\n");
        printf("mul            - Multiply top two values on stack\n");
        printf("div            - Divide top two values on stack\n");
        printf("add R1         - Add top value from stack to R1\n");
        printf("add R2         - Add top value from stack to R2\n");
        printf("sub R1         - Subtract top value from stack from R1\n");
        printf("sub R2         - Subtract top value from stack from R2\n");
        printf("mul R1         - Multiply top value from stack with R1\n");
        printf("mul R2         - Multiply top value from stack with R2\n");
        printf("div R1         - Divide R1 by top value from stack\n");
        printf("div R2         - Divide R2 by top value from stack\n");
        printf("cmp            - Compare R1 and R2\n");
        printf("mark <label>   - Set a mark (label) at current position\n");
        printf("call <label>   - Call a mark (label)\n");
        printf("return         - Return to the last called mark\n");
        printf("if=<label>     - If top of stack is 0, go to <label>\n");
        printf("if><label>     - If top of stack is positive, go to <label>\n");
        printf("if<<label>     - If top of stack is negative, go to <label>\n");
        printf("loop <label>   - Loop to <label> a number of times\n");
        printf("goto <label>   - Go to <label>\n");
        printf("cmp R1         - Compare pop() and R1, print result\n");
        printf("cmp R2         - Compare pop() and R2, print result\n");
        printf("mod R1         - Modulo pop() and R1, store result in R1\n");
        printf("mod R2         - Modulo pop() and R2, store result in R2\n");
        printf("print R1       - Print value of R1\n");
        printf("print R2       - Print value of R2\n");
        printf("print stack    - Print all values in the stack\n");
        printf("print          - Print all values in the stack and R1, R2\n");
        printf("pop            - Pop value from stack\n");
        printf("exit           - Exit the program\n");
        printf("reset          - Reset the stack and registers\n");
        printf("clear          - Clear the stack\n");
        printf("list           - List all commands in the program\n");
        printf("mod            - Push (pop() % pop()) onto stack\n");
        return;
    }
    else if (strcmp(command, "print R1") == 0) {// PRINT R1
        printf("R1: %d\n", sm->R1);
        return;
    }
    else if (strcmp(command, "print R2") == 0) {// PRINT R2
        printf("R2: %d\n", sm->R2);
        return;
    }
    else if (strcmp(command, "print stack") == 0) {// PRINT STACK
        printf("Stack: ");
        for (int i = 0; i < sm->top; i++) {
            printf("%d ", sm->stack[i]);
        }
        printf("\n");
        return;
    }
    else if (strcmp(command, "print") == 0) {// PRINT
        printf("Stack: ");
        for (int i = 0; i < sm->top; i++) {
            printf("%d ", sm->stack[i]);
        }
        printf("\n");
        printf("R1: %d\n", sm->R1);
        printf("R2: %d\n", sm->R2);
        return;
    }  
    else if (command == NULL || command[0] == '\0') {
        return;
    }
    else if (strncmp(command, "set R1", 6) == 0)// SET R1 
    {
        int value = atoi(command + 7);
        sm->R1 = value;
    }
    else if (strncmp(command, "set R2", 6) == 0)// SET R2
    {
        int value = atoi(command + 7);
        sm->R2 = value;
    }
    else if (strncmp(command, "mark", 4) == 0) { // MARK
        if (mark_count >= 10) {
            printf("the maximum number of labels has been reached!\n");
            return;
        }
        strcpy(mark[mark_count].name, command + 5);
        mark[mark_count].pc = sm->pc;
        mark[mark_count].repeat = -1;// инициализируем то что потом будем использовать сразу , нул нам там все карты путает
        mark_count++;
    }
    else if (strncmp(command, "loop", 4) == 0) { // LOOP
        const char *metka = command + 5;//LOOP *mark*
        int temp=-1;
        for (int i = 0; i < mark_count; i++)
        {
            if (strcmp(mark[i].name, metka) == 0)
            {
                temp=i;
                break;
            }
        }
        if (temp==-1)
        {
            printf("the label '%s' was not found!\n", metka);
        }
        //
        if (mark[temp].repeat == -1) {
          mark[temp].repeat = sm->R2;
        }
        if (mark[temp].repeat == 0) {
            mark[temp].repeat = -1;
            return;
        }
        else{
            mark[temp].repeat--;
            sm->pc = mark[temp].pc - 1;  // -1 т.к. потом будет pc++
            return;
        }
    }
    else if (strncmp(command, "goto", 4) == 0) { // GOTO
        
        const char *metka = command + 5;//GOTO *mark*
        for (int i = 0; i < mark_count; i++)
        {
            if (strcmp(mark[i].name, metka) == 0)
            {
                sm->pc = mark[i].pc - 1;  // -1 т.к. потом будет pc++
                return;
            }
        }
        printf("the label '%s' was not found!\n", metka);
    }
        else if (strncmp(command, "call", 4) == 0) { // CALL
        if (return_top >= 100) {
        printf("Return stack overflow!\n");
        return;
        }
        return_stack[return_top++] = sm->pc + 1;
        const char *label_name = command + 5;
        for (int i = 0; i < mark_count; i++) {
            if (strcmp(mark[i].name, label_name) == 0) {
                sm->pc = mark[i].pc - 1;  // -1 т.к. потом будет pc++
                return;
            }
        }
        printf("the label '%s' was not found!\n", label_name);
    }
    else if (strcmp(command, "return") == 0) {// RETURN
        if (return_top == 0) {
            printf("error: the refund stack is empty!\n");
            return;
        }
        sm->pc = return_stack[--return_top];  // восстанавливаем pc
    }
//======================== Основные команды ==========================
    else if (strncmp(command, "push R1", 7) == 0) // PUSH R1
    {
        push(sm, sm->R1);
    }
    else if (strncmp(command, "push R2", 7) == 0)// PUSH R2
    {
        push(sm, sm->R2);
    }
    else if (strncmp(command, "push", 4) == 0) {// PUSH
        if (sm->top >= STACK_SIZE) {
            printf("stack overflow!\n");
            return;
        }
        int value = atoi(command + 5);
        push(sm, value);
    }
    else if (strncmp(command, "pop R1", 6) == 0) // POP R1
    {
        sm->R1 = pop(sm);
    }
    else if (strncmp(command, "pop R2", 6) == 0)// POP R2
    {
        sm->R2 = pop(sm);
    } 
    else if (strcmp(command, "add") == 0) {// ADD
        if (sm->top < 2) {  // минимум 2 элемента
        printf("error: stack has less than 2 elements!\n");
        return;
        }
        int a = pop(sm);
        int b = pop(sm);
        push(sm, a + b);
    }
    else if (strcmp(command, "sub") == 0) {// SUB
        // Вычитание
        int a = pop(sm);
        int b = pop(sm);
        push(sm, b-a);
    }
    else if (strcmp(command, "mul") == 0) {// MUL
        int a = pop(sm);
        int b = pop(sm);
        push(sm, a * b);
    }
    else if (strcmp(command, "div") == 0) {// DIV
        // Деление
        int a = pop(sm);
        int b = pop(sm);
        if (a != 0) {
            push(sm, b/a);
        } else {
            printf("Division by zero!\n");
        }
    }
    else if (strcmp(command,"add R1"))// ADD R1
    {
        sm->R1+= pop(sm);
    }
    else if (strcmp(command,"add R2"))// ADD R2
    {
        sm->R2+= pop(sm);
    }
    else if (strcmp(command,"sub R1"))// SUB R1
    {
        sm->R1= pop(sm)-sm->R1;
    }
    else if (strcmp(command,"sub R2"))// SUB R2
    {
        sm->R2= pop(sm)-sm->R2;
    }
    else if (strcmp(command,"mul R1"))// MUL R1
    {
        sm->R1*= pop(sm);
    }
    else if (strcmp(command,"mul R2"))// MUL R2
    {
        sm->R2*= pop(sm);
    }
    else if (strcmp(command,"div R1"))// DIV R1
    {
        int a = pop(sm);
        int b = sm->R1;
        if (b != 0) {
            sm->R1= a/b;
        } else {
            printf("division by zero!\n");
        }
    }
    else if (strcmp(command,"div R2"))// DIV R2
    {
        int a = pop(sm);
        int b = sm->R2;
        if (b != 0) {
            sm->R2= a/b;
        } else {
            printf("division by zero!\n");
        }
    }
    else if (strcmp(command,"cmp") == 0)// CMP
    {
        if (sm->R1>sm->R2) {
            push(sm, 1);
            printf("R1>R2 -> push 1\n");
        } else if (sm->R1<sm->R2) {
            push(sm, -1);
            printf("R1<R2 -> push -1\n");
        } else {
            push(sm, 0);
            printf("R1=R2 -> push 0\n");
        }
    }
    
    else if (strncmp(command, "if=", 3) == 0) { // IF=*mark*
        if (sm->top > 0 && sm->stack[sm->top - 1] == 0)// перейти на метку если в вершине стека 0
        {
            const char *metka = command + 3;//+4 ? IF= *mark*
            for (int i = 0; i < mark_count; i++)
            {
                if (strcmp(mark[i].name, metka) == 0)
                {
                    sm->pc = mark[i].pc - 1;  // -1 т.к. потом будет pc++
                    return;
                }
            }
            printf("the label '%s' was not found!\n", metka);
        }
    }
    else if (strncmp(command, "if>", 3) == 0) { // IF>*mark*
        if (sm->top > 0 && sm->stack[sm->top - 1] == 0)// перейти на метку если в вершине стека положительное чсло
        {
            const char *metka = command + 3;//+4 ? IF> *mark*
            for (int i = 0; i < mark_count; i++)
            {
                if (strcmp(mark[i].name, metka) == 0)
                {
                    sm->pc = mark[i].pc - 1;  // -1 т.к. потом будет pc++
                    return;
                }
            }
            printf("the label '%s' was not found!\n", metka);
        }
    }
    else if (strncmp(command, "if<", 3) == 0) { // IF<*mark*
        if (sm->top > 0 && sm->stack[sm->top - 1] == 0)// перейти на метку если в вершине стека отрицательное чсло
        {
            const char *metka = command + 3;//+4 ? IF< *mark*
            for (int i = 0; i < mark_count; i++)
            {
                if (strcmp(mark[i].name, metka) == 0)
                {
                    sm->pc = mark[i].pc - 1;  // -1 т.к. потом будет pc++
                    return;
                }
            }
            printf("the label '%s' was not found!\n", metka);
        }
    }
    
//======================== дополнительные команды ==========================
    else if (strcmp(command,"cmp") == 0)// CMP
    {
        if (sm->R1>sm->R2) {
            push(sm, 1);
            printf("R1>R2 -> push 1\n");
        } else if (sm->R1<sm->R2) {
            push(sm, -1);
            printf("R1<R2 -> push -1\n");
        } else {
            push(sm, 0);
            printf("R1=R2 -> push 0\n");
        }
    }
    else if (strcmp(command,"cmp R1"))// CMP R1
    {
        int a = pop(sm);
        int b = sm->R1;
        if (a == b) {
            printf("equal\n");
        } else if (a > b) {
            printf("greater\n");
        } else {
            printf("less\n");
        }
    }
    else if (strcmp(command,"cmp R2"))// CMP R2
    {
        int a = pop(sm);
        int b = sm->R2;
        if (a == b) {
            printf("equal\n");
        } else if (a > b) {
            printf("greater\n");
        } else {
            printf("less\n");
        }
    }
    else if (strcmp(command,"mod R1"))// MOD R1
    {
        int a = pop(sm);
        int b = sm->R1;
        if (b != 0) {
            sm->R1= a%b;
        } else {
            printf("division by zero!\n");
        }
    }
    else if (strcmp(command,"mod R2"))// MOD R2
    {
        int a = pop(sm);
        int b = sm->R2;
        if (b != 0) {
            sm->R2= a%b;
        } else {
            printf("division by zero!\n");
        }
    }

    else if (strcmp(command, "pop") == 0) {// POP
        if (sm->top <= 0) {
            printf("stack underflow!\n");
            return;
        }
        pop(sm);
    }
    else if (strcmp(command, "exit") == 0) {// EXIT
        exit(0);
    }
    else if (strcmp(command, "reset") == 0) {// RESET
        // for (int i = 0; i < sm->top; i++) {
        //     sm->stack[i] = 0;
        // } // не требуется
        sm->top = 0;
        sm->R1 = 0;
        sm->R2 = 0;
        printf("Machine reset.\n");
    }
    else if (strcmp(command, "clear") == 0) {// CLEAR
        sm->top = 0;
        printf("Stack cleared.\n");
    }
    
    else if (strcmp(command, "list") == 0) {// LIST
        // вывод программы
        printf("Program:\n");
        for (int i = 0; sm->program[i] != NULL; i++) {
            printf("%d: %s\n", i, sm->program[i]);
        }
    }
    else if (strcmp(command, "mod") == 0) {// MOD
        // остаток от деления
        int a = pop(sm);
        int b = pop(sm);
        if (b != 0) {
            push(sm, a % b);
        } else {
            printf("Division by zero!\n");
        }
    }
    else {
    printf("Unknown command: %s\n", command);
    fflush(stdout);
    return;
    }
    
    
}

int main() {
    StackMachine sm = {0};  // Обнуляем стек и регистры
    
    //(2 + 3) * 4
    const char *program[] = {//ok

        "push 2",
        "push 3",
        "add",
        "push 4",
        "mul",
        "print",
        "help",
        NULL

    };
    const char *program2[] = {
        "push 1",
        "set R2 5",
        "mark zloop",
        "push 2",
        "add",
        "print",
        "loop zloop",//goto OK ; call OK; loop(r2) OK
        NULL
    };
    const char *program3[] = {//ok
        "push 2",
        "set R2 5",
        "push 2",
        "add",
        "print",
        NULL
    };
    
    // загружаем
    for (int i = 0; program2[i] != NULL; i++) {
        sm.program[i] = strdup(program2[i]);
    }
    // исполняем
    sm.pc = 0;
    while (sm.program[sm.pc] != NULL) {
        printf("executing: %s (stack size: %d)\n", sm.program[sm.pc], sm.top);
        fflush(stdout);
        execute(&sm, sm.program[sm.pc]);
        sm.pc++;
    }
    getchar();
    printf("=== END ===\n");
    fflush(stdout);
    system("pause");
}
