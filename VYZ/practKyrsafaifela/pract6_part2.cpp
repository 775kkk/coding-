#include <stdio.h>  
#include <malloc.h>

typedef struct Root {
    int SecondResult;
    bool flagZnaka;
    int mainChisl;
    int secondChisl;
    int flagPriorityOP;
    bool isTotchka;
    double totchkaFactor;
    struct Root *prev;
} Root;

Root* createRoot() {
    Root *newRoot = (Root *)malloc(sizeof(Root));
    newRoot->SecondResult = 0;
    newRoot->flagZnaka = true;
    newRoot->mainChisl = 0;
    newRoot->secondChisl = 0;
    newRoot->flagPriorityOP = 0;
    newRoot->prev = NULL;
    newRoot->isTotchka = false;
    newRoot->totchkaFactor = 0.1;
    // newRoot->ZNAK = '\0';
    return newRoot;
}
Root* insertAtNOW_NewRoot(Root *head) {// вставка в начало рута(стека)
    Root *newRoot = createRoot();
    if (head == NULL) {
        return newRoot;
    }
    newRoot->prev=head;
    return newRoot;
}

Root* deleteNOW_MainRoot(Root *head) {// удаление текущего рута
    if (head == NULL) {
        return NULL;
    }
    Root *temp = head;
    head = head->prev;
    free(temp);
    return head;
}

Root* deleteAllRoot(Root *head) {// удаление всех рутов
    if (head == NULL) {
        return head;
    }
    Root *temp = head;
    while (head) {
        temp = head;
        head = head->prev;
        free(temp);
    }
    return head;
}
//=======================================================================================================
// хранилище знаков стеком
//=======================================================================================================
typedef struct Node {
    char data;
    struct Node *perv;
} NodeChar;

Node* createNode(char data) {// создание ноды
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->data = data;
    newNode->perv = NULL;
    return newNode;
}

Node* addAtNode(Node *head, char data) {// добавление в начало стека
    Node *newNode = createNode(data);
    if (head == NULL) {
        return newNode;
    }
    newNode->perv = head;
    return newNode;
}
Node* deleteNode(Node *head) {// удаление ноды
    if (head == NULL) {
        return NULL;
    }
    Node *temp = head;
    head = head->perv;
    free(temp);
    return head;
}
Node* deleteAllNode(Node *head) {// удаление всех нод
    if (head == NULL) {
        return head;
    }
    Node *temp = head;
    while (head) {
        temp = head;
        head = head->perv;
        free(temp);
    }
    return head;
}

// int VblCHISLI(char* strM){
//     int result=0;
//     bool flagZnaka=true;// текущий знак плюс
//     int mainChisl=0;// текущее число 0
//     int secondChisl=0;// прошедшее число
//     int flagPriorityOP;// 0 1* 2/ 3//
//     for (int i = 0; strM[i]!='\0'; i++)
//     {
//         if (strM[i]>57)
//         {
//             // continue;//если букава пох
//         }
//         else if ((strM[i]-'0')>=0)//если число
//         {
//             mainChisl*=10;//поднимаем на разряд текущее рассматриваемое число че там было ну парсинг
//             mainChisl+=(strM[i]-'0');// плюсуем текущее в текущее число
//         }
//         else{// если не буква и не число то знак определяемся дальше у нас обычный знак или приоритет умножения всякого ЕЩЕ НАДО СКОБЫ СДЕЛАТЬ
//             // -4+9*11-2/3
//             (flagPriorityOP!=0) ? (flagPriorityOP==1) ? secondChisl*=mainChisl : secondChisl/=mainChisl : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо
//             if ((strM[i]=='*' || strM[i]=='/')&& mainChisl!=0)// если действие приоритетное ну то есть умножение всякое то
//             {
//                 flagPriorityOP = strM[i]=='*' ? 1 : 2;// орпеделяем деление или умножения зашифровываем в переменную че да как
//                 secondChisl=mainChisl;// складываем число до знака в соответствующую переменную
//                 mainChisl=0;// обнуляем текущее число так как прошел знак
//             }
//             else{
//                 secondChisl!=0 ? mainChisl=secondChisl : NULL; //решаем было ли чето в старом числе, если было значит мы тут после приоритетного действия значит надо обработать данные после этого
//                 result+=(flagZnaka ? (mainChisl) : (mainChisl)*-1);// плюсуем в результ чтото в зависимости от знака (дефолт = отсутсвие знака значит плюс значит труе)
//                 mainChisl=0;// обнуляем текущее число так как прошел знак
//                 flagPriorityOP =0; // обнуляем так как прошел знак обычного приоритета
//                 secondChisl=0;// тк прошел знак обычного приоритета 
//                 (strM[i]=='-' || strM[i]=='+') ? flagZnaka= (strM[i]=='-' ? false : true): NULL; // так как текущий символ это знак мы его обрабатываем чтобы юзнуть на 2 строки ранее нужный знак
//             }
//             // для скобок предлагаю кароче сделать также приоритет как и для умножения только теперь 3 переменных мейн число прошедшее2 и сумма скобки 
//         }

//     /*для тестов*/ 
//         // printf("sikl %i, result=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",i+1,result,mainChisl,secondChisl,flagZnaka,flagPriorityOP);
    
//     }

//     /*для тестов*/ 
//     // printf("sikl PREend, result=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",result,mainChisl,secondChisl,flagZnaka,flagPriorityOP);

//     (flagPriorityOP!=0) ? (flagPriorityOP==1) ? secondChisl*=mainChisl : secondChisl/=mainChisl : NULL ;
//     flagPriorityOP!=0 ? mainChisl=secondChisl : NULL;//обрабатываем случай когда после приоритетной операции не последовало знака
//     result+=(flagZnaka ? (mainChisl) : (mainChisl)*-1);

//     /*для тестов*/ 
//     // printf("sikl end, result=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",result,mainChisl,secondChisl,flagZnaka,flagPriorityOP);

//     return result;
// }


int VblCHISLI(char* strM){
    int result=0;
    Root *mainRoot = createRoot();
    for (int i = 0; strM[i]!='\0'; i++)
    {

        if (strM[i] == '.') {
            mainRoot->isTotchka = true;
        }
        else if (strM[i] >= '0' && strM[i] <= '9')//если число
        {
            // mainRoot->mainChisl*=10;//поднимаем на разряд текущее рассматриваемое число че там было ну парсинг
            // mainRoot->mainChisl+=(strM[i]-'0');// плюсуем текущее в текущее число
            if (mainRoot->isTotchka) {
                mainRoot->mainChisl += (strM[i] - '0') * mainRoot->totchkaFactor;
                mainRoot->totchkaFactor *= 0.1;
            } else {
                mainRoot->mainChisl = mainRoot->mainChisl * 10 + (strM[i] - '0');
            }
            
        }
        else{// если не буква и не число то знак определяемся дальше у нас обычный знак или приоритет умножения всякого ЕЩЕ НАДО СКОБЫ СДЕЛАТЬ
            // -4+9*11-2/3

            // <просто факт что прошел знак>
            mainRoot->isTotchka = false;
            mainRoot->totchkaFactor = 0.1;
            // <\просто факт что прошел знак>
          
                if (strM[i]=='(')
                {
                    mainRoot = insertAtNOW_NewRoot(mainRoot);// переключаем рут на новый
                    
                }
                // NULLroot(secondRoot); NULLroot*secondRoot
                // NULLroot(secondRoot)thridRoot; NULLroot*secondRoot*thridRoot
                // NULLroot(secondRoot)+thidRoot; NULLroot*secondRoot+thidRoot
                // NULLroot+(secondRoot)*thidRoot; NULLroot+secondRoot*thidRoot
                // ⤷ 9+2/2*3-1+(1+1+1)*6+2 --> хорошо если перед скобой знаки +- то мы не можем сразу делать действие
                // ⤷-> 9+2/2*(1+1+1)*6+2 --> ок тут сразу можно умнгожить и збыть наху;
                // ⤷-> 9*(-1)
                // ⤷-> 9+(1+1)*8*9*1
                else if (strM[i]==')')
                {   
                    
                    if (mainRoot->prev==NULL)
                    {
                        /* ЗНАЧИТ ЭТО МЕЙН МЕЙНОВ РУТ */
                    }
                    else
                    {
                        mainRoot->secondChisl!=0 ? mainRoot->mainChisl=mainRoot->secondChisl : NULL; //решаем было ли чето в старом числе, если было значит мы тут после приоритетного действия значит надо обработать данные после этого
                        mainRoot->SecondResult+=(mainRoot->flagZnaka ? (mainRoot->mainChisl) : (mainRoot->mainChisl)*-1);// плюсуем в результ чтото в зависимости от знака (дефолт = отсутсвие знака значит плюс значит труе)
                        mainRoot->prev->mainChisl=mainRoot->SecondResult;
                        mainRoot = deleteNOW_MainRoot(mainRoot);
                    }
                    
                    
                }
                else if ((strM[i]=='*' || strM[i]=='/')&& mainRoot->mainChisl!=0)// если действие приоритетное ну то есть умножение всякое то
                {   
                    (mainRoot->flagPriorityOP!=0) ? ((mainRoot->flagPriorityOP==1) ? (mainRoot->secondChisl*=mainRoot->mainChisl) : (mainRoot->secondChisl/=mainRoot->mainChisl)) : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо

                    mainRoot->flagPriorityOP = strM[i]=='*' ? 1 : 2;// орпеделяем деление или умножения зашифровываем в переменную че да как
                    mainRoot->secondChisl=mainRoot->mainChisl;// складываем число до знака в соответствующую переменную
                    mainRoot->mainChisl=0;// обнуляем текущее число так как прошел знак
                }
                else{// если + - НУ тоесть обычное чето что мы сразу оперируем
                    // втсавлено тут тк на скобке у нас и не может быть действия и на уже скобке flagPriorityOP==1 что тригерит строку ниже А МЕЙН ЧИСЛО РАВНО НУЛЮ ЛОООЛ
                    (mainRoot->flagPriorityOP!=0) ? ((mainRoot->flagPriorityOP==1) ? (mainRoot->secondChisl*=mainRoot->mainChisl) : (mainRoot->secondChisl/=mainRoot->mainChisl)) : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо


                    mainRoot->secondChisl!=0 ? mainRoot->mainChisl=mainRoot->secondChisl : NULL; //решаем было ли чето в старом числе, если было значит мы тут после приоритетного действия значит надо обработать данные после этого
                    mainRoot->SecondResult+=(mainRoot->flagZnaka ? (mainRoot->mainChisl) : (mainRoot->mainChisl)*-1);// плюсуем в результ чтото в зависимости от знака (дефолт = отсутсвие знака значит плюс значит труе)
                    mainRoot->mainChisl=0;// обнуляем текущее число так как прошел знак
                    mainRoot->flagPriorityOP =0; // обнуляем так как прошел знак обычного приоритета
                    mainRoot->secondChisl=0;// тк прошел знак обычного приоритета 
                    (strM[i]=='-' || strM[i]=='+') ? mainRoot->flagZnaka= (strM[i]=='-' ? false : true): NULL; // так как текущий символ это знак мы его обрабатываем чтобы юзнуть на 2 строки ранее нужный знак
                }
                // для скобок предлагаю кароче сделать также приоритет как и для умножения только теперь 3 переменных мейн число прошедшее2 и сумма скобки 
            
        }

    /*для тестов*/ 
        printf("sikl %i, result=%i, rootResult=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",i,result,mainRoot->SecondResult,mainRoot->mainChisl,mainRoot->secondChisl,mainRoot->flagZnaka,mainRoot->flagPriorityOP);

    }

    /*для тестов*/ 
    printf("sikl PREend,  result=%i, rootResult=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",result,mainRoot->SecondResult,mainRoot->mainChisl,mainRoot->secondChisl,mainRoot->flagZnaka,mainRoot->flagPriorityOP);

    (mainRoot->flagPriorityOP!=0) ? (mainRoot->flagPriorityOP==1) ? mainRoot->secondChisl*=mainRoot->mainChisl : mainRoot->secondChisl/=mainRoot->mainChisl : NULL ;
    mainRoot->flagPriorityOP!=0 ? mainRoot->mainChisl=mainRoot->secondChisl : NULL;//обрабатываем случай когда после приоритетной операции не последовало знака
    mainRoot->SecondResult+=(mainRoot->flagZnaka ? (mainRoot->mainChisl) : (mainRoot->mainChisl)*-1);

    result = mainRoot->SecondResult;
    /*для тестов*/ 
    printf("sikl end, result=%i, rootResult=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",result,mainRoot->SecondResult,mainRoot->mainChisl,mainRoot->secondChisl,mainRoot->flagZnaka,mainRoot->flagPriorityOP);

    
    deleteAllRoot(mainRoot);
    return result;
}

int main(){
    // char* stroka = "-4+9*11+1/2";// ожидаем 95
    // char* stroka = "6.24+6/3.2"; // ожидаем 8.124 получаем 8 так как НЕТУ DOUBLE loool xddd xdxdxd
    char* stroka = "4+6-6(1+1)2"; // ожидаем 23
    printf("%i\n", VblCHISLI(stroka));
    // printf("%i", 1/2);
}
