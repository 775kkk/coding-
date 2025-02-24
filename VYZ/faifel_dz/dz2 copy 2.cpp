#include <stdio.h>

#define MAX_Zveno 100

typedef struct Zveno {
    int data;
    struct Zveno* next;
} Zveno;

Zveno Zvenya[MAX_Zveno];
int ZvenoCount = 0;

Zveno* createZveno(int data) {
    if (ZvenoCount >= MAX_Zveno) {
        printf("Zvenya zapolnenbl\n");
        return NULL;
    }
    Zvenya[ZvenoCount].data = data;
    Zvenya[ZvenoCount].next = NULL;
    return &Zvenya[ZvenoCount++];
}
// вставка элемента в конец списка
Zveno* vstavkaVspisok(Zveno* head, int data) {
    Zveno* newZveno = createZveno(data);
    if (head == NULL) {
        return newZveno;
    }
    Zveno* temp = head;
    while (temp->next) {
        temp = temp->next;
    }
    temp->next = newZveno;
    return head;
}

Zveno* vstavkaVnachaloSpiska(Zveno* head, int data) {
    Zveno* newZveno = createZveno(data);
    newZveno->next = head;
    return newZveno;
}

// добавляет элемент в список перед указанным элементом
Zveno* vstavkaPeredElemontom(Zveno* head, int data, int element) {
    Zveno* newZveno = createZveno(data);
    if (head == NULL || head->data == element) {
        newZveno->next = head;
        return newZveno;
    }
    Zveno* temp = head;
    while (temp->next) {
        if (temp->next->data == element) {
            newZveno->next = temp->next;
            temp->next = newZveno;
            return head;
        }
        temp = temp->next;
    }
    return head;
}
Zveno* deliteSpisok(Zveno* head) {
    Zveno* temp = head;
    while (temp) {
        Zveno* next = temp->next;
        temp->next = NULL;
        temp->data = NULL;
        temp = next;
    }
    return NULL;
}   
Zveno* printSpisok(Zveno* head) {
    Zveno* temp = head;
    while (temp) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    return head;
}

int main() {
    Zveno* head = NULL;
    head = vstavkaVspisok(head, 1);
    head = vstavkaVspisok(head, 2);
    head = vstavkaVspisok(head, 3);
    head = vstavkaVnachaloSpiska(head, 4);
    head = vstavkaPeredElemontom(head, 5, 2);
    printSpisok(head);
    deliteSpisok(head);
}