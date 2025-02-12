#include <stdio.h>
#include <exception>

void printChislo(float a){
    printf("%f:",a);
    if (a>0)
    {
        printf("_|");
        for (int i = 0; i < int(a); i++)
        {
            printf("#");
        }
        int b=int((a*10))%10;
        // printf("\n%i\n",b);
        for (int i = 0; i < b; i++)
        {
            printf("*");
        }
    }else if (a<0)
    {
        int b = ((int(a*10))%10)*-1;
        for (int i = 0; i < b; i++)
        {
            printf("*");
        }
        a*=-1;
        for (int i = 0; i < int(a); i++)
        {
            printf("#");
        }
        printf("|_");
    }
    else if(a==0)
    {
        printf("_|_");
    }  
}

void printChisloVert(float a){
    printf("%f:",a);
    if (a>0)
    {
        printf("\n");
        int b=int((a*10))%10;
        for (int i = 0; i < b; i++)
        {
            printf("*\n");
        }
        for (int i = 0; i < int(a); i++)
        {
            printf("#\n");
        }
        
        printf("-\n|");
    }else if (a<0)
    {
        printf("\n|\n-\n");
        a*=-1;
        for (int i = 0; i < int(a); i++)
        {
           printf("#\n");
        }
        int b = ((int(a*10))%10);
        for (int i = 0; i < b; i++)
        {
            printf("*\n");
        }
        
        
    }
    else if(a==0)
    {
        printf("|\n-\n|");
    }  
}

void printChislo(int a){
    printf("%i:",a);
    if (a>0)
    {
        printf("_|");
        for (int i = 0; i < int(a); i++)
        {
            printf("#");
        }
    }else if (a<0)
    {
        a*=-1;
        for (int i = 0; i < int(a); i++)
        {
            printf("#");
        }
        printf("|_");
    }
    else if(a==0)
    {
        printf("_|_");
    }  
}

void printChisloVert(int a){
    printf("%i:",a);
    if (a>0)
    {
        printf("\n");
        for (int i = 0; i < int(a); i++)
        {
            printf("#\n");
        }
        printf("-\n|");
    }else if (a<0)
    {
        printf("\n-\n|\n");
        a*=-1;
        for (int i = 0; i < int(a); i++)
        {
            printf("#\n");
        }

    }
    else if(a==0)
    {
        printf("\n|\n-\n|");
    }  
}

void schetMass(int* mass, int len){
    int sum=0;
    int proizv=1;
    for (size_t i = 0; i < len; i++)
    {
        sum+=mass[i];
        proizv*=mass[i];
    }
    printf("summ= ");
    printChislo(sum);
    printf("\nproizv= ");
    printChislo(proizv);
    printf("\nsrArifm= ");
    printChislo(float(sum)/len);
}


// сортировка массива по ybblvaniy <myfunc.h>
void sorted(int* stroka,int Mlen){
    int sortLen = 0;
    int NEsortLen = Mlen;
    int max;
    int mIndex=0;
    while (sortLen!=Mlen){   
        max=-32767;
        for (int i = sortLen; i!=Mlen; i++){
            if (stroka[i]>max){
                max=stroka[i];
                mIndex=i;
            }
        }
        stroka[mIndex]=stroka[sortLen];
        stroka[sortLen]=max;
        sortLen++;
    }
}

//вот некст задача поинтереснее и мне аукнется то что я все делал через принтф а не в список и строки в принтф=элементы в массиве
// но кому не по поэтому мы продолжим через принтф фигачить

//сделать функ которая принтует масив в таком виде и еще есть масштаб который отвечает за цену одной решотки
// 8:_|########
// 5:_|#####
// 2:_|##
// ----------
// -2:##|_
// -7:#######|_

void printChislo(int a, int size){
    printf("%i:",a);
    int b=a;
    if (b>0)
    {
        b+=b%size;
        printf("_|");
        for (int i = 0; i < int(b); i+=size)
        {
            printf("#");
        }
    }else if (b<0)
    {
        b=b*(-1);
        if (b%size!=0)
        {
            b-=size-b%size;
        }
        // printf("SAAKSFKKSF  %i DKKDKKD\n",b);
        // 25 => 20 , size 20
        for (int i = 0; i < int(b); i+=size)
        {
            printf("#");
        }
        printf("|_");
    }
    else if(b==0)
    {
        printf("_|_");
    }  
}

void settingsMassive(int* mass, int len, int size){
    // size - масштаб = сколько стоит одна решетка или звездочка
    sorted(mass,len);
    bool flajok=false;
    bool flajok2=true;
    for (int i = 0; i < len; i++)
    {
        if (flajok && flajok2){
            printf("----------\n");
            flajok2=false;
        }
        else if (flajok2)
        {
            try
            {
                if (mass[i+1]<0)
                {
                    flajok=true;
                }
            }
            catch(const std::exception& e){}
        }
        printChislo(mass[i],size);
        printf("\n");
    }
    

}
int main(){
    float a=-5.9;
    int c = -6;
    // printChisloVert(c); // - сделать кароче сначала чтобы было отображение числа в формате решетки звездочки вертикально и гоизонтально

    int mass[5]={2,5,-7,-2,8};
    // сумм=24, перемнож=1120 , ср арифм = 4.98
    // schetMass(mass,5); // - просто типа характеристика массива в формате звезд и решеток
    settingsMassive(mass,5,1);
    // еще кароче сделать зависимость от колва положительных и отрицательных -> эта зависимость определит как будет отриосвываться массив горизонтально или вертикально лол

}
