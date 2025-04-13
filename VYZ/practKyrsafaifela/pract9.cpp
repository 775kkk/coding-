#include <stdio.h>
#include <malloc.h>

// сортировка подсчетом
// cat
void printMass(int *mass,int len){
    for (int i = 0; i < len; i++)
    {
        printf("%d ", mass[i]);
    }
}

void sortPodscetom(int *mass, int Mlen, int maxChislo){
    int* sklad = (int*)calloc(maxChislo, sizeof(int));
    for (size_t i = 0; i < Mlen; i++)
    {
        sklad[mass[i]]++;
    }
    printMass(sklad,maxChislo);
    int indexSklada=0;
    int temp=0;
    for (size_t i = 0; i <Mlen; i++)
    {
        // if((i<sklad[indexSklada]+temp)&&(indexSklada!=0)){
        //     mass[i]=indexSklada;
        // }
        // else{
        //     mass[i]=indexSklada;
        //     indexSklada++;
        //     temp+=i;
        // }
        // sklad[indexSklada]!=0 ? mass[i]=indexSklada : NULL;// даже если 0 повторений все равно заполнит
        // if (i==sklad[indexSklada]+temp){
        //     indexSklada++;
        //     temp+=i;
        // }
        // mass[i]=indexSklada пока i<(indexSklada+temp) а temp
        // if (i<(indexSklada+temp))
        // {
        //     mass[i]=indexSklada;
        // }else{
        //     indexSklada++;
        //     temp+=i;
        // }

        if (sklad[indexSklada]!=0 || sklad[indexSklada]<0){
            mass[i]=indexSklada;
            sklad[indexSklada]--;
        }else{//==0 
            indexSklada++;
        }
        
        
    }
    free(sklad);
}


int main(){
    int arr1[10] = {10,24,3,11,5,7,8,9,1,23};
    int* mass = (int*)malloc(9 * sizeof(int));
    for (size_t i = 0; i < 10; i++){
        mass[i] = arr1[i];
    }
    // printMass(mass,10);
    sortPodscetom(mass,10,24);
    printf("\n");
    printMass(mass,10);


}