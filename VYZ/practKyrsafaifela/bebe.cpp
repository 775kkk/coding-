#include <stdio.h>
#include <malloc.h>

typedef struct NodeInt {
    int data;
    struct NodeInt *next;
} NodeInt;

NodeInt* createNodeInt(int data) {
    NodeInt *newNodeInt = (NodeInt *)malloc(sizeof(NodeInt));
    newNodeInt->data = data;
    newNodeInt->next = NULL;
    return newNodeInt;
}

NodeInt* insertAtEnd(NodeInt *head, int data) {
    NodeInt *newNodeInt = createNodeInt(data);
    if (head == NULL) {
        return newNodeInt;
    }
    NodeInt *temp = head;
    while (temp->next) {
        temp = temp->next;
    }
    temp->next = newNodeInt;
    return head;
}
void sorted(int* stroka,int Mlen){
    // par = 1 -> по возврастанию TRUE
    // par = 0 -> по убыванию     FALSE
    int sortLen = 0;
    int NEsortLen = Mlen;
    int min;
    int mIndex=0;
    while (sortLen!=Mlen){   
        min=32767;
        for (int i = sortLen; i!=Mlen; i++){
            if (stroka[i]<min){
                min=stroka[i];
                mIndex=i;
            }
        }
        stroka[mIndex]=stroka[sortLen];
        stroka[sortLen]=min;
        sortLen++;
    }
}

NodeInt* sortirovka(NodeInt *head){
    int Mlen=0;
    NodeInt *temp = head;
    for (; temp!=NULL;)
    {
        Mlen++;
        temp=temp->next;
    }
    // узнали длину
    int sortLen = 0;
    int min;
    int z;
    NodeInt *mINDEXtemp1;// узел с наим числом
    NodeInt *temp2= head;// узел перед последним сорт числом
    while (sortLen!=Mlen){   
        min=32767;
        temp=head;
        for (int i = 0; i!=Mlen; i++){
            if ((temp->data<min) && (i>=sortLen)){
                min=temp->data;
                mINDEXtemp1=temp;
            }
            temp=temp->next;
        }
        z=mINDEXtemp1->data;
        mINDEXtemp1->data=temp2->data;
        temp2->data=z;
        temp2=temp2->next;
        sortLen++;
    }
    return head;
}
    
    

int main() {
    NodeInt *head = createNodeInt(22);
    insertAtEnd(head,14);
    insertAtEnd(head,4);
    insertAtEnd(head,54);

    sortirovka(head);
    NodeInt* temp = head;
  	while(temp) {
      printf("%i ", temp->data);
      temp = temp->next;
    }
}
