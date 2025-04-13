#include <stdio.h>
#include <malloc.h>

typedef struct yzelokDereva{
    int data;
    struct yzelokDereva *levo;
    struct yzelokDereva *pravo;
} yzelokDereva;


yzelokDereva* createYzelok(int data){
    yzelokDereva *NEWyzelokDereva = (yzelokDereva *)malloc(sizeof(yzelokDereva));
    NEWyzelokDereva->data=data;
    return NEWyzelokDereva;
}

yzelokDereva* creaateTree(yzelokDereva* head, int data, int i) {
    if (head == NULL) {
        return createYzelok(data);
    }
    if (i%2!=0) {
        head->levo = creaateTree(head->levo, data,i);
    }
    if (i%2==0) {
        head->pravo = creaateTree(head->pravo, data,i);
    }
    return head;
}

void printTree(yzelokDereva* root) {
    if (root != NULL) {
        printTree(root->levo);
        printf("%d ", root->data);
        printTree(root->pravo);
    }
}


// пирамидальная сортировка

yzelokDereva* createTree(int *mass, int Mlen){
    if (mass[0]==NULL)
    {
        printf("mass[0]==null");
        return NULL;
    }
    if (Mlen==0 || Mlen==NULL)
    {
        printf("unnormal Mlen lol");
    }
    yzelokDereva *head=createYzelok(mass[0]);
    // yzelokDereva *tempVerh;
    // bool levo=false;
    // yzelokDereva *mainYzel=head;
    // yzelokDereva *futureYzel;



    for (int i = 1; i < Mlen; i++)
    {
        //mass[i]
        // if (mainYzel->levo==NULL)
        // {
        //     mainYzel->levo=createYzelok(mass[i]);
        // }
        // if (mainYzel->pravo==NULL)
        // {
        //     mainYzel->pravo=createYzelok(mass[i]);
        // }
        // else{
        //     if (!levo)
        //     {   
        //         tempVerh=mainYzel;
        //         mainYzel=mainYzel->levo;
        //         levo=true;
        //     }
        //     if (levo)
        //     {
        //         futureYzel=mainYzel->levo;
        //         mainYzel=tempVerh->pravo;// че типа я себя обрег на проклятье не воспринимать рекурсивность как рекурсию?
        //         // ладненько проклятье так проклятье
                
        //     }
        //     if (levo третье значение)
        //     {
        //         mainYzel=futureYzel;
        //         levo=false;
        //         // типа завершенность цикла и далее он же по новой лол но тогда у нас просто правые ветки пойдут лесом
        //         // крч опять меня невзначай понесло реализоввывать рекурсию без реурсии...
        //     }
        // }

        // 1 2 4 8 16 32 64 128 ;; 2^1++ -> power*=2
        // можно попытаться сыграть на факте что мы знаем глубину дерева тк знаем всего колво элементов и на каком элементе сейчас и просто прыгать от головы дерева на нужную глубину какимто образом и заполнять ее в поярдке очереди хах
        // но я крч мнал делать тыщу лет через тыщу боли это поэтому свистнул рекурсию, я же в обществе живу среди людей а не один на свете лол, мы команда
        head=creaateTree(head,mass[i],i);
    }
    
    
}

int main(){


}