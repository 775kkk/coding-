#include <stdio.h>
#include <malloc.h>

// -6+2076-4*3/2+56*3

// if ((strM[i]-'0')>=0)
//         {
//             result+=(flagZnaka ? +(strM[i]-'0') : -(strM[i]-'0'));
//         }
//         else
//         {   
//             if (true)
//             {
//             flagZnaka= (strM[i]=='-' ? false : true); 
//             }
            
//         }
        

int VblCHISLI(char* strM){
    int result=0;
    bool flagZnaka=true;// текущий знак плюс
    int mainChisl=0;// текущее число 0
    int secondChisl=0;// прошедшее число
    int flagPriorityOP;// 0 1* 2/ 3//
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
                secondChisl!=0 ? mainChisl=secondChisl : NULL; //решаем было ли чето в старом числе, если было значит мы тут после приоритетного действия значит надо обработать данные после этого
                result+=(flagZnaka ? (mainChisl) : (mainChisl)*-1);// плюсуем в результ чтото в зависимости от знака (дефолт = отсутсвие знака значит плюс значит труе)
                mainChisl=0;// обнуляем текущее число так как прошел знак
                flagPriorityOP =0; // обнуляем так как прошел знак обычного приоритета
                secondChisl=0;// тк прошел знак обычного приоритета 
                (strM[i]=='-' || strM[i]=='+') ? flagZnaka= (strM[i]=='-' ? false : true): NULL; // так как текущий символ это знак мы его обрабатываем чтобы юзнуть на 2 строки ранее нужный знак
            }
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