#include <stdio.h>  
#include <malloc.h>

typedef struct stepeni{
    int data;
    struct stepeni *perv;
} stepeni;

typedef struct Root {
    int SecondResult;
    bool flagZnaka;
    int mainChisl;
    int secondChisl;
    int flagPriorityOP;
    bool isTotchka;
    double totchkaFactor;
    int vozvedeynieVstepen;
    struct Root *prev;
    stepeni *skladStepens;
} Root;


stepeni* createStepenNode(){
    stepeni *newStepenNode = (stepeni *)malloc(sizeof(stepeni));
    // newStepenNode->data = data;
    newStepenNode->perv = NULL;
    return newStepenNode;
}

stepeni* insertAtNOW_newStepen(stepeni *head){
    stepeni *newStepenNode = createStepenNode();
    if (head==NULL)
    {
        return newStepenNode;
    }
    newStepenNode->perv=head;
    return newStepenNode;
}

stepeni* deleteNOW_mainStepen(stepeni *head){
    if (head == NULL) {
        return NULL;
    }
    stepeni *temp = head;
    head = head->perv;
    free(temp);
    return head;
}

stepeni* deleteAllstepeni(stepeni *head) {// удаление всех
    if (head == NULL) {
        return head;
    }
    stepeni *temp = head;
    while (head) {
        temp = head;
        head = head->perv;
        free(temp);
    }
    return head;
}

Root* createRoot() {
    Root *newRoot = (Root *)malloc(sizeof(Root));
    newRoot->SecondResult = 0;
    newRoot->flagZnaka = true;
    newRoot->mainChisl = 0;
    newRoot->secondChisl;
    newRoot->flagPriorityOP = 0;
    newRoot->prev = NULL;
    newRoot->isTotchka = false;
    newRoot->totchkaFactor = 0.1;
    newRoot->vozvedeynieVstepen=false;
    newRoot->skladStepens=createStepenNode();
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
 
long long binpow(long long vozvodimoe, long long vchtoVozvodim){//возведение в степень
    long long result=0;
    while (vchtoVozvodim>0)
    {
        if (vchtoVozvodim%2==1) {result*=vozvodimoe;}
        vozvodimoe*=vozvodimoe;
        vchtoVozvodim/=2;
    }
    return result;
}

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
                
                if (strM[i]=='^')// 434353^3443 // по идее надо свитч руут 3423^33434^4343 -> 3423^(33434^4343) -> 3423^(33434^(4343)) // по сути приоритетное действие как с умножением но тут важна последовательность действий
                {
                    mainRoot->vozvedeynieVstepen++;
                    insertAtNOW_newStepen(mainRoot->skladStepens);
                    mainRoot->skladStepens->data=mainRoot->mainChisl;
                }
                
                else if (mainRoot->vozvedeynieVstepen!=0)
                {
                    while (mainRoot->vozvedeynieVstepen!=0)// О НЕТ ЦИКЛ В ЦИКЛЕ !!!!!!!!!!!!!!! ! ! ! ! ! ! !  ! НА КОСТЕР ЕГО РЕБЯТ ! 1! !! ! ! ! ! ! ! !
                    {
                        // mainRoot->skladStepens->data=binpow(mainRoot->skladStepens->data,mainRoot->skladStepens->perv->data);
                        mainRoot->mainChisl=binpow(mainRoot->skladStepens->data,mainRoot->mainChisl);
                        mainRoot->skladStepens=deleteNOW_mainStepen(mainRoot->skladStepens);
                        mainRoot->vozvedeynieVstepen--;
                    }
                    
                    // mainRoot->mainChisl=binpow(mainRoot->mainChisl,mainRoot->skladStepens->data);
                }
                
                else if (strM[i]=='(')
                {
                    if (mainRoot->mainChisl!=0 && (strM[i-1] >= '0' && strM[i-1] <= '9'))// эта штука чисто для число и сразу скобка что в математике считается умножением меджу скобой и числом
                    {
                        (mainRoot->flagPriorityOP!=0) ? ((mainRoot->flagPriorityOP==1) ? (mainRoot->secondChisl*=mainRoot->mainChisl) : (mainRoot->secondChisl/=mainRoot->mainChisl)) : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо
                   
                        (mainRoot->flagPriorityOP==0) ? mainRoot->secondChisl=mainRoot->mainChisl : NULL;// складываем число до знака в соответствующую переменную
                        // если приоритет опрерация уже была то мы это обработали вверху и мейн число нам более не надо
                        mainRoot->flagPriorityOP = 1;// орпеделяем  умножениe зашифровываем в переменную че да как
                        mainRoot->mainChisl=0;// обнуляем текущее число так как прошел знак
                        // printf("%i\n",mainRoot->secondChisl);

                    }
                    
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
                    else// 8(21)2
                    {
                        // по идее этого не должно быть тк мы на скобке и тут не может быть действия
                        // (mainRoot->flagPriorityOP!=0) ? ((mainRoot->flagPriorityOP==1) ? (mainRoot->secondChisl*=mainRoot->mainChisl) : (mainRoot->secondChisl/=mainRoot->mainChisl)) : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо

                        // mainRoot->secondChisl!=0 ? mainRoot->mainChisl=mainRoot->secondChisl : NULL; //решаем было ли чето в старом числе, если было значит мы тут после приоритетного действия значит надо обработать данные после этого
                        mainRoot->flagPriorityOP!=0 ? mainRoot->mainChisl=mainRoot->secondChisl : NULL; //ты идиот тебе блять флаг приорити опирейшен все говорит ты ИДИОТ
                        mainRoot->SecondResult+=(mainRoot->flagZnaka ? (mainRoot->mainChisl) : (mainRoot->mainChisl)*-1);// плюсуем в результ чтото в зависимости от знака (дефолт = отсутсвие знака значит плюс значит труе)
                        mainRoot->prev->mainChisl=mainRoot->SecondResult;
                        
                        // ()? : mainRoot->prev->mainChisl=mainRoot->SecondResult;
                        mainRoot = deleteNOW_MainRoot(mainRoot);
                        if((strM[i+1] >= '0' && strM[i+1] <= '9')||strM[i+1]=='('){// чисто для случая когда скобка и сразу число )9 что означает умножение
                            
                            // (mainRoot->flagPriorityOP!=0) ? ((mainRoot->flagPriorityOP==1) ? (mainRoot->secondChisl*=mainRoot->mainChisl) : (mainRoot->secondChisl/=mainRoot->mainChisl)) : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо

                            // (mainRoot->flagPriorityOP!=0) ? mainRoot->secondChisl*=mainRoot->mainChisl : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо
                            // вместо верхней
                            (mainRoot->flagPriorityOP!=0) ? ((mainRoot->flagPriorityOP==1) ? (mainRoot->secondChisl*=mainRoot->mainChisl) : (mainRoot->secondChisl/=mainRoot->mainChisl)) : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо

                            // так как чисто технически тут знак поставился 
                            mainRoot->flagPriorityOP = 1;// орпеделяем деление или умножения зашифровываем в переменную че да как
                            //тут опасненько тк мы тупа замещаем то что есть в секонд числе без понимания знака
                    
                    printf("sikl %i mejdy %i, result=%i, rootResult=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",i,i+1,result,mainRoot->SecondResult,mainRoot->mainChisl,mainRoot->secondChisl,mainRoot->flagZnaka,mainRoot->flagPriorityOP);

                            // (mainRoot->secondChisl!=0)? NULL : mainRoot->secondChisl=mainRoot->mainChisl;// складываем число до знака в соответствующую переменную
                            (mainRoot->flagPriorityOP==0) ? mainRoot->secondChisl=mainRoot->mainChisl : NULL;// ТЫ ИДИОТ
                            mainRoot->mainChisl=0;// обнуляем текущее число так как прошел знак
                        }
                    }
                    
                    
                }
                else if ((strM[i]=='*' || strM[i]=='/')&& mainRoot->mainChisl!=0)// если действие приоритетное ну то есть умножение всякое то
                {   

                    (mainRoot->flagPriorityOP!=0) ? ((mainRoot->flagPriorityOP==1) ? (mainRoot->secondChisl*=mainRoot->mainChisl) : (mainRoot->secondChisl/=mainRoot->mainChisl)) : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо
                    
                    // если приоритет опрерация уже была то мы это обработали вверху и мейн число нам более не надо
                    (mainRoot->flagPriorityOP==0) ? mainRoot->secondChisl=mainRoot->mainChisl : NULL;// складываем число до знака в соответствующую переменную
                    mainRoot->flagPriorityOP = strM[i]=='*' ? 1 : 2;// орпеделяем деление или умножения зашифровываем в переменную че да как
                    mainRoot->mainChisl=0;// обнуляем текущее число так как прошел знак
                }
                else{// если + - НУ тоесть обычное чето что мы сразу оперируем
                    // втсавлено тут тк на скобке у нас и не может быть действия и на уже скобке flagPriorityOP==1 что тригерит строку ниже А МЕЙН ЧИСЛО РАВНО НУЛЮ ЛОООЛ
                    (mainRoot->flagPriorityOP!=0) ? ((mainRoot->flagPriorityOP==1) ? (mainRoot->secondChisl*=mainRoot->mainChisl) : (mainRoot->secondChisl/=mainRoot->mainChisl)) : NULL ;//если знак умножения или деления был и тут появляется еще знак то есть число кончилось то мы выполняем с нашими двумя числами что надо


                    // mainRoot->secondChisl!=0 ? mainRoot->mainChisl=mainRoot->secondChisl : NULL; //решаем было ли чето в старом числе, если было значит мы тут после приоритетного действия значит надо обработать данные после этого
                    mainRoot->flagPriorityOP!=0 ? mainRoot->mainChisl=mainRoot->secondChisl : NULL; //ты идиот тебе блять флаг приорити опирейшен все говорит ты ИДИОТ
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

    if (mainRoot->vozvedeynieVstepen!=0)
    {
        while (mainRoot->vozvedeynieVstepen!=0)// О НЕТ ЦИКЛ В ЦИКЛЕ !!!!!!!!!!!!!!! ! ! ! ! ! ! !  ! НА КОСТЕР ЕГО РЕБЯТ ! 1! !! ! ! ! ! ! ! !
        {
            // mainRoot->skladStepens->data=binpow(mainRoot->skladStepens->data,mainRoot->skladStepens->perv->data);
            mainRoot->mainChisl=binpow(mainRoot->skladStepens->data,mainRoot->mainChisl);
            mainRoot->skladStepens=deleteNOW_mainStepen(mainRoot->skladStepens);
            mainRoot->vozvedeynieVstepen--;
        }
        
        // mainRoot->mainChisl=binpow(mainRoot->mainChisl,mainRoot->skladStepens->data);
    }

    (mainRoot->flagPriorityOP!=0) ? (mainRoot->flagPriorityOP==1) ? mainRoot->secondChisl*=mainRoot->mainChisl : mainRoot->secondChisl/=mainRoot->mainChisl : NULL ;
    mainRoot->flagPriorityOP!=0 ? mainRoot->mainChisl=mainRoot->secondChisl : NULL;//обрабатываем случай когда после приоритетной операции не последовало знака
    mainRoot->SecondResult+=(mainRoot->flagZnaka ? (mainRoot->mainChisl) : (mainRoot->mainChisl)*-1);

    result = mainRoot->SecondResult;
    /*для тестов*/ 
    printf("sikl end, result=%i, rootResult=%i, mainchisl=%i, secondChisl=%i, flagZnaka=%i,flagPriorityOP=%i,\n",result,mainRoot->SecondResult,mainRoot->mainChisl,mainRoot->secondChisl,mainRoot->flagZnaka,mainRoot->flagPriorityOP);

    deleteAllstepeni(mainRoot->skladStepens);
    deleteAllRoot(mainRoot);
    return result;
}

int main(){
    // char* stroka = "-4+9*11+1/2";// ожидаем 95
    // char* stroka = "6.24+6/3.2"; // ожидаем 8.124 получаем 8 так как НЕТУ DOUBLE loool xddd xdxdxd
    // char* stroka = "4+6-6(1+1)2"; // ожидаем 23
    char* stroka = ""; // ожидаем 352
    printf("%i\n", VblCHISLI(stroka));
    // printf("%i", 8/22);
}
