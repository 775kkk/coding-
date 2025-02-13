//гробищееееееееееееееееееееееее
#include <stdio.h>
#include <malloc.h>

//надо отрисовать график плоскости с ограничениями ну по иксу и игрику
char** grafik(int plusX, int minusX, int plusY, int minusY){
    int lenOneStr = ((plusX<0 ? +(plusX*-1) : +(plusX))+(minusX<0 ? +(minusX*-1) : +(minusX)))+1;//+1 на херню за ноль, за '\0' учтем вконце
    int lenAllStr = ((plusY<0 ? +(plusY*-1) : +(plusY))+(minusY<0 ? +(minusY*-1) : +(minusY)))+1;//тупа по модулю все суммируем
    char** ITOGgrafik = (char**)malloc((lenAllStr)*sizeof(char*));
    for (int i = 0; i < lenAllStr; i++)
    {   

        ITOGgrafik[i]=(char*)malloc((lenOneStr+1)*sizeof(char));
        if (i==(lenAllStr-1)/2)
        {
            // ITOGgrafik[i]=(char*)malloc((lenOneStr+1)*sizeof(char));
            *ITOGgrafik[i]=('-'*minusX)+('+')+('-'*plusX)+'\0'; // ТУТ ОШИБК ТИПА МЫ ВАЩЕ В ЛЮБОМ СЛУАЧАЕ ОТРИСУЕМ ПЕРЕСЕЧЕНИЕ БЕЗ ВСТАВКИ ПРЕДПОЛАГАЕМОЙ ЗВЕЗДЫ??!!
        }
        else{
            for (int j = 0; j < lenOneStr; j++)
            {
                //определяемся
                if (j==lenOneStr/2)
                {
                    ITOGgrafik[i][j]='|';
                }
                else
                {
                    // тут  уже проверяем пусто или звездочка
                    if (lenAllStr-i==)//формула по которой узнаем звезда ли
                    {
                        /* code */
                    }else{ ITOGgrafik[i][j]='_';}
                    
                }
            }
            ITOGgrafik[i][lenOneStr+1]='\0';
        }
    }
    

}

int main(){


}