//гробищееееееееееееееееееееееее
#include <stdio.h>
#include <malloc.h>

//я хер знает как организовать данные
char** grafik(int plusX, int minusX, int plusY, int minusY){
    int lenOneStr = ((plusX<0 ? +(plusX*-1) : +(plusX))+(minusX<0 ? +(minusX*-1) : +(minusX)))+1;//+1 на херню за ноль, за '\0' учтем вконце
    int lenAllStr = ((plusY<0 ? +(plusY*-1) : +(plusY))+(minusY<0 ? +(minusY*-1) : +(minusY)))+1;//тупа по модулю все суммируем
    char** ITOGgrafik = (char**)malloc((lenAllStr)*sizeof(char*));
    for (int i = 0; i < lenAllStr; i++)
    {   
        //отрисовка строки
        (ITOGgrafik)[i]=(char*)malloc((lenOneStr+1)*sizeof(char));
            for (int j = 0; j < lenOneStr; j++)
            {
                if (j==(minusX<0 ? (minusX*-1) : (minusX)))
                {
                    if (i==plusY){
                        (ITOGgrafik)[i][j]='+';
                    }
                    else{
                        (ITOGgrafik)[i][j]='|';
                    }
                }else if (i==plusY){
                    (ITOGgrafik)[i][j]='=';
                }else{
                    (ITOGgrafik)[i][j]='-';
                }                
            }    
        (ITOGgrafik)[i][lenOneStr]='\0';  
        // puts((*ITOGgrafik)[i]);
    }
     return ITOGgrafik;
}

void kxbFunc(char** grafik,int plusX, int minusX, int plusY, int minusY, int k, int b){
    int lenOneStr = ((plusX<0 ? +(plusX*-1) : +(plusX))+(minusX<0 ? +(minusX*-1) : +(minusX)))+1;//+1 на херню за ноль, за '\0' учтем вконце
    int lenAllStr = ((plusY<0 ? +(plusY*-1) : +(plusY))+(minusY<0 ? +(minusY*-1) : +(minusY)))+1;//тупа по модулю все суммируем
    int mainY;
    int mainX;
    for (int i = 0; i < lenAllStr; i++)
    {
        mainY=(plusY<0 ? +(plusY*-1) : +(plusY))-i;
        for (int j = 0; j < lenOneStr; j++)
        {
            mainX=(minusX<0 ? (minusX) : (minusX*-1))+j;
            if (mainY==(k*mainX)+b)
            {
                grafik[i][j]='*';
                // printf("i=%d j=%d\n",i,j);
                // printf("lenAllStr-1-i=%d (k*j)-b=%d\n",lenAllStr-1-i,(k*j)-b);
            }
        }
        // puts(grafik[i]);
    }
}

void parabolaFunc(char** grafik,int plusX, int minusX, int plusY, int minusY, int a, int b, int c){
    int lenOneStr = ((plusX<0 ? +(plusX*-1) : +(plusX))+(minusX<0 ? +(minusX*-1) : +(minusX)))+1;//+1 на херню за ноль, за '\0' учтем вконце
    int lenAllStr = ((plusY<0 ? +(plusY*-1) : +(plusY))+(minusY<0 ? +(minusY*-1) : +(minusY)))+1;//тупа по модулю все суммируем
    int mainY;
    int mainX;
    for (int i = 0; i < lenAllStr; i++)
    {
        mainY=(plusY<0 ? +(plusY*-1) : +(plusY))-i;
        for (int j = 0; j < lenOneStr; j++)
        {
            mainX=(minusX<0 ? (minusX) : (minusX*-1))+j;
            if (mainY==(a*mainX*mainX)+(b*mainX)+c)
            {
                grafik[i][j]='*';
                // printf("i=%d j=%d\n",i,j);
                // printf("lenAllStr-1-i=%d (k*j)-b=%d\n",lenAllStr-1-i,(k*j)-b);
            }
        }
        // puts(grafik[i]);
    }
}

int main(){
    int plusX=20;
    int minusX=20;
    int plusY=25; 
    int minusY=20;
    // char** gr = grafik(5,5,5,5);
    char** gr = grafik(plusX,minusX,plusY,minusY);
    kxbFunc(gr,plusX,minusX,plusY,minusY,1,0);
    parabolaFunc(gr,plusX,minusX,plusY,minusY,1,0,0);
    // kxbFunc(gr,sizeDataPack[0],sizeDataPack[1],1,0);
    // kxbFunc(gr,sizeDataPack[0],sizeDataPack[1],1,1);
    // parabolaFunc(gr,sizeDataPack[0],sizeDataPack[1],1,0,0);
    int lenAllStr = ((plusY<0 ? +(plusY*-1) : +(plusY))+(minusY<0 ? +(minusY*-1) : +(minusY)))+1;
    for (int i = 0; i <lenAllStr; i++)
    {   
        puts(gr[i]);
    }
    // кароче там еще задание посчитать площадь под графиком и площадь меж двумя графиками(параболами) но я рт е прост бы формулой какойто посчитал и мозги не делал
    // под линейным это то еще ладно, под параболой тоже аналогично мб хотя там не везде звездочки, а вот меж двумя параболами это капецы
}
