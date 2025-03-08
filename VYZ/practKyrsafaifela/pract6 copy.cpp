#include <stdio.h>
#include <malloc.h>

// кароче сделай руут так чтобы добавлялось только в начало и начало потом удалялось а 
// в рабочем поле было текущее руут это по сути начало цепочки ну стек не тупи

typedef struct Root {
    int SecondResult=0;
    bool flagZnaka=true;// текущий знак плюс
    int mainChisl=0;// текущее число 0
    int secondChisl=0;// прошедшее число
    int flagPriorityOP;// 0 1* 2/ 3//
    struct Root *next;
} Root;

Root* createRoot() {
    Root *newRoot = (Root *)malloc(sizeof(Root));
    newRoot->next = NULL;
    return newRoot;
}
Root* insertAtEndNewRoot(Root *head) {
    Root *newRoot = createRoot();
    if (head == NULL) {
        return newRoot;
    }
    newRoot->next=head;
    return newRoot;
}

typedef struct Node {
    char data;
    struct Node *next;
} NodeChar;
typedef struct Node {
    int data;
    struct Node *next;
} NodeInt;

NodeInt* createNode(int data) {
    NodeInt *newNodeInt = (NodeInt *)malloc(sizeof(NodeInt));
    newNodeInt->data = data;
    newNodeInt->next = NULL;
    return newNodeInt;
}
NodeChar* createNode(char data) {
    NodeChar *newNodeChar = (NodeChar *)malloc(sizeof(NodeChar));
    newNodeChar->data = data;
    newNodeChar->next = NULL;
    return newNodeChar;
}

NodeInt* insertAtEnd(NodeInt *head, int data) {
    NodeInt *newNodeInt = createNode(data);
    if (head == NULL) {
        return newNodeInt;
    }
    NodeInt *temp = head;
    while (temp->next) {
        temp = temp->next;
    }
    temp->next = newNodeInt;
    return head;
}

NodeChar* insertAtEnd(NodeChar *head, char data) {
    NodeChar *newNodeChar = createNode(data);
    if (head == NULL) {
        return newNodeChar;
    }
    NodeChar *temp = head;
    while (temp->next) {
        temp = temp->next;
    }
    temp->next = newNodeChar;
    return head;
}

Node* deleteAtEnd(Node *head) {
    if (head == NULL) {
        printf("List is empty!\n");
        return head;
    }
    if (head->next == NULL) {
        free(head);
        return NULL;
    }
    Node *temp = head;
    while (temp->next->next) {
        temp = temp->next;
    }
    free(temp->next);
    temp->next = NULL;
    return head;
}

Node* deleteSpisok(Node *head) {
    if (head == NULL) {
        printf("List is empty!\n");
        return head;
    }
    Node *temp = head;
    while (head) {
        temp = head;
        head = head->next;
        free(temp);
    }
    return head;
}
// -6)))))+2076-4*3/2+(56*3)

int VblCHISLI(char* strM,){// сделай точки
    int result=0;
    // bool flagZnaka=true;// текущий знак плюс
    // int mainChisl=0;// текущее число 0
    // int secondChisl=0;// прошедшее число
    // int flagPriorityOP;// 0 1* 2/ 3//
    Root *MainRoot=createRoot();
    NodeChar *skladOperaciySkobok = createNode('0');
    size_t countSkobki = 0;
    // int flagImpotantPriorityOP;
    for (int i = 0; strM[i]!='\0'; i++)
    {
        if (strM[i]>57)
        {
            // continue;//если букава пох
        }
        else if ((strM[i]-'0')>=0)//если число
        {
            mainChisl*=10;//поднимаем на разряд текущее рассматриваемое число че там было ну парсинг
            mainChisl+=(strM[i]-'0');// плюсуем текущее в текущее число
        }
        else{// если не буква и не число то знак определяемся дальше у нас обычный знак или приоритет умножения всякого ЕЩЕ НАДО СКОБЫ СДЕЛАТЬ
            // -4+9*11-2/3
            (flagPriorityOP!=0) ? (flagPriorityOP==1) ? secondChisl*=mainChisl : secondChisl/=mainChisl : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо
            if ((strM[i]=='*' || strM[i]=='/')&& mainChisl!=0)// если действие приоритетное ну то есть умножение всякое то
            {
                flagPriorityOP = strM[i]=='*' ? 1 : 2;// орпеделяем деление или умножения зашифровываем в переменную че да как
                secondChisl=mainChisl;// складываем число до знака в соответствующую переменную
                mainChisl=0;// обнуляем текущее число так как прошел знак
            }
            else{// если сложение и другое обычного приоритета действие то  
                // ТУТ 4 состояния : 
                // если скобка открылась
                // если скобка все еще идет
                // если скобка закрылась
                // если скобки нет
                
                // 9(62+3/4-(11-2)/2)
                // (strM[i]=='(' || strM[i]==')') ? (strM[i]=='(' ? flagImpotantPriorityOP++ : flagImpotantPriorityOP--): NULL;
                // окей если у нас после числа скобка и получается что мейн число не пусто но имеется скобка то получается надо выполнить блок кода от умножения но 
                // if (strM[i]=='(' || strM[i]==')')// начинаем врубаться за состояние
                // {
                //     if (mainChisl!=0)
                //     {
                //         flagPriorityOP=1;
                //     }
                //     strM[i]=='(' ? flagImpotantPriorityOP++ : flagImpotantPriorityOP--;                    
                // }
                if (strM[i]=='(')// если скобка открылась
                {// 8*8*9(32+8*(7/3))
                    //запоминаем знак перед скобкой и что скобка открылась
                    countSkobki++;
                    if (strM[i-1]>57){/*ignore Но помни что тебе точки надо будет но тут врядли*/}
                    else if (((strM[i-1]-'0')>=0) || (strM[i]=='*')){
                        insertAtEnd(skladOperaciySkobok,'*');
                    }else if (strM[i]=='/'){
                        insertAtEnd(skladOperaciySkobok,'/');
                    }else if (strM[i]=='-'){
                        insertAtEnd(skladOperaciySkobok,'-');
                    }else if (strM[i]=='+'){
                        insertAtEnd(skladOperaciySkobok,'+');
                    }
                    
                    
                }
                



                secondChisl!=0 ? mainChisl=secondChisl : NULL; //решаем было ли чето в старом числе, если было значит мы тут после приоритетного действия значит надо обработать данные после этого
                result+=(flagZnaka ? (mainChisl) : (mainChisl)*-1);// плюсуем в результ чтото в зависимости от знака (дефолт = отсутсвие знака значит плюс значит труе)
                mainChisl=0;// обнуляем текущее число так как прошел знак
                flagPriorityOP =0; // обнуляем так как прошел знак обычного приоритета
                secondChisl=0;// тк прошел знак обычного приоритета 
                (strM[i]=='-' || strM[i]=='+') ? flagZnaka= (strM[i]=='-' ? false : true): NULL; // так как текущий символ это знак мы его обрабатываем чтобы юзнуть на 2 строки ранее нужный знак
            }
            // для скобок предлагаю кароче сделать также приоритет как и для умножения только теперь 3 переменных мейн число прошедшее2 и сумма скобки 
        }
    /*для тестов*/ 
        // printf("sikl %i, result=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",i+1,result,mainChisl,secondChisl,flagZnaka,flagPriorityOP);
    }
    /*для тестов*/ 
    // printf("sikl PREend, result=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",result,mainChisl,secondChisl,flagZnaka,flagPriorityOP);
    (flagPriorityOP!=0) ? (flagPriorityOP==1) ? secondChisl*=mainChisl : secondChisl/=mainChisl : NULL ;
    flagPriorityOP!=0 ? mainChisl=secondChisl : NULL;//обрабатываем случай когда после приоритетной операции не последовало знака
    result+=(flagZnaka ? (mainChisl) : (mainChisl)*-1);
    /*для тестов*/ 
    // printf("sikl end, result=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",result,mainChisl,secondChisl,flagZnaka,flagPriorityOP);
    return result;
    

}

int main(){

    // char* stroka = "-6+2076-4*3/2+56*3";
    // char i = '0';
    // int c = (int)('6');
    // int result = 1;
    // char strM = '5';
    // result=int( result+(strM-'0'));

    // printf("%i,%i,%i,%i,%i",'0','9','a');
    // printf("\n%i",'-');
    // printf("\n%i",')'-'0');

    char* stroka = "-4+9*11+1/2";
    printf("%i\n", VblCHISLI(stroka));
    printf("%i", 1/2);




}