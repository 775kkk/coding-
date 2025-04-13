#include <stdio.h>
#include <malloc.h>

void swapaem(int *a, int *b){
    int temp = *a;
    *a=*b;
    *b=temp;
}

void printMass(int *mass,int len){
    for (int i = 0; i < len; i++)
    {
        printf("%i ", mass[i]);
    }
}

// пирамидальная сортиврока

void heapify(int *mass, int len,int i){
    int root=i;
    int levo=2*i+1;
    int pravo=2*i+2;
    if(levo<len && mass[levo]<mass[root]){
        root=levo;
    }
    if(pravo<len && mass[pravo]<mass[root]){
        root=pravo;
    }
    if(root!=i){
        swapaem(&mass[i],&mass[root]);
        heapify(mass,len,root);
    }
}

void hepSorting(int *mass,int len){
    for(int i = len/2-1;i>=0;i--){
        heapify(mass,len,i);
    }
    for(int i = len-1;i>=0;i--){
        swapaem(&mass[0],&mass[i]);
        heapify(mass,i,0);
    }
}

// квиксортная сортировка
int delemMassiv(int *mass,int minLen ,int maxLen){
    int center = minLen+(maxLen-minLen)/2;// (maxLen-1)/2 ?
    int oporka=mass[center];
    swapaem(&mass[center],&mass[maxLen]);// пихаем вконец наш срединный элементик

    int i = minLen-1;// точка разделения наших двух массивов 
    for (int j = minLen; j < maxLen; j++)
    {
        if (mass[j]<=oporka)
        {
            i++;
            swapaem(&mass[i],&mass[j]);
        }
    }//поперемещали все элементы меньше или равные опорному в самое начало отслеживая их цепочку через i
    swapaem(&mass[i+1],&mass[maxLen]);// тепер то чо кидали назад кидаем в середину и ретурним как разделител
    return i+1;
    
}
void qsort(int *mass, int minLen ,int maxLen){
    if (minLen<maxLen)
    {
        int razdelitel = delemMassiv(mass, minLen,maxLen);
        // ну и разделяем с одновременной сортировкой рекурсивным образом
        qsort(mass,minLen,razdelitel-1);
        qsort(mass,razdelitel+1,maxLen);
    }
    
}

int main(){
    int arr1[10] = {10,24,3,11,5,7,8,9,1,23};
    int* mass = (int*)malloc(9 * sizeof(int));
    for (size_t i = 0; i < 10; i++){
        mass[i] = arr1[i];
    }
    printMass(mass,10);
    qsort(mass,0,9);
    printf("\n");
    printMass(mass,10);
}