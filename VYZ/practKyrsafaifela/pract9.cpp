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
    for (int i = 0; i < Mlen; i++)
    {
        sklad[mass[i]]++;
    }
    printMass(sklad,maxChislo);
    int indexSklada=0;
    int temp=0;
    for (int i = 0; i <Mlen; i++)
    {
        //в тот день невероятно жеско тупил прямо ваще капец хуже чем на еге
        // еще меня этот дед на файфеле грузил, ну он с нами душевно болтал и я на него отвлекался, он буквально над ухом стоял и рассказывал всякое, поначалу я пытался чето написать потом уже забил и начал фул его слушать
        if (sklad[indexSklada]==0){
            indexSklada++;
            i--;// это вот заменило вложеннось циклов)))))))
            i<-1 ? i=0: NULL;
        }else{ 
            mass[i]=indexSklada;
            sklad[indexSklada]--;
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