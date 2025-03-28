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
NodeInt* insertAtBeginning(NodeInt *head, int data) {
    NodeInt *newNodeInt = createNodeInt(data);
    newNodeInt->next = head;
    return newNodeInt;
}
NodeInt* insertAtPosition(NodeInt *head, int data, int position) {
    if (position < 0) {
        printf("Invalid position!\n");
        return head;
    }
    if (position == 0) {
        return insertAtBeginning(head, data);
    }
    NodeInt *newNodeInt = createNodeInt(data);
    NodeInt *temp = head;
    while (position > 1) {
        if (temp == NULL) {
            printf("Invalid position!\n");
            return head;
        }
        temp = temp->next;
        position--;
    }
    newNodeInt->next = temp->next;
    temp->next = newNodeInt;
    return head;
}
NodeInt* insertAtElement(NodeInt *head, int data, int element) {
    NodeInt *newNodeInt = createNodeInt(data);
    if (head == NULL) {
        return newNodeInt;
    }
    NodeInt *temp = head;
    while (temp->data != element) {
        temp = temp->next;
        if (temp == NULL) {
            printf("Element not found!\n");
            return head;
        }
    }
    newNodeInt->next = temp->next;
    temp->next = newNodeInt;
    return head;
}
// удаляет вначале
NodeInt* deleteAtBeginning(NodeInt *head) {
    if (head == NULL) {
        printf("List is empty!\n");
        return head;
    }
    NodeInt *temp = head;
    head = head->next;
    free(temp);
    return head;
}
// удаляет весь
NodeInt* deleteSpisok(NodeInt *head) {
    if (head == NULL) {
        printf("List is empty!\n");
        return head;
    }
    NodeInt *temp = head;
    while (head) {
        temp = head;
        head = head->next;
        free(temp);
    }
    return head;
}
//удаляет вконце
NodeInt* deleteAtEnd(NodeInt *head) {
    if (head == NULL) {
        printf("List is empty!\n");
        return head;
    }
    if (head->next == NULL) {
        free(head);
        return NULL;
    }
    NodeInt *temp = head;
    while (temp->next->next) {
        temp = temp->next;
    }
    free(temp->next);
    temp->next = NULL;
    return head;
}
// удаляет в позиции
NodeInt* deleteAtPosition(NodeInt *head, int position) {
    if (position < 0) {
        printf("Invalid position!\n");
        return head;
    }
    if (position == 0) {
        return deleteAtBeginning(head);
    }
    NodeInt *temp = head;
    while (position > 1) {
        if (temp == NULL) {
            printf("Invalid position!\n");
            return head;
        }
        temp = temp->next;
        position--;
    }
    if (temp == NULL || temp->next == NULL) {
        printf("Invalid position!\n");
        return head;
    }
    NodeInt *NodeIntToDelete = temp->next;
    temp->next = temp->next->next;
    free(NodeIntToDelete);
    return head;
}
// удаляет элемент
NodeInt* deleteAtElement(NodeInt *head, int element) {
    if (head == NULL) {
        printf("List is empty!\n");
        return head;
    }
    if (head->data == element) {
        return deleteAtBeginning(head);
    }
    NodeInt *temp = head;
    while (temp->next && temp->next->data != element) {
        temp = temp->next;
    }
    if (temp->next == NULL) {
        printf("Element not found!\n");
        return head;
    }
    NodeInt *NodeIntToDelete = temp->next;
    temp->next = temp->next->next;
    free(NodeIntToDelete);
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

int sortirovka(NodeInt *head){
    int len=0;
    while (head->next!=NULL)
    {
        len++;
    }
    return len;
    
}

int main() {
    NodeInt *first = (NodeInt *)malloc(sizeof(NodeInt));
 
    first->data = 23;

    NodeInt *second = (NodeInt *)malloc(sizeof(NodeInt));

    second->data = 44;

    NodeInt *third = (NodeInt *)malloc(sizeof(NodeInt));

    third->data = 30;

    first->next = second; 
    second->next = third; 
    third->next = NULL;   
//f s t
// ok head = first
    // printf("linked list: ");
    // NodeInt* temp = first;
  	// while(temp) {
    //   printf("%d ", temp->data);
    //   temp = temp->next;
    // }

    printf("%i",sortirovka(first));
}
