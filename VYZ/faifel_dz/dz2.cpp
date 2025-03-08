// C Program to create a Linked List
#include <stdio.h>
#include <malloc.h>

// Define the structure of NodeInt
typedef struct NodeInt {
  
    // Data field. Can add more data according to our need
    int data;

    // Pointer to the next NodeInt
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

int main() {
    NodeInt *first = (NodeInt *)malloc(sizeof(NodeInt));
 
    first->data = 10;

    NodeInt *second = (NodeInt *)malloc(sizeof(NodeInt));

    second->data = 20;

    NodeInt *third = (NodeInt *)malloc(sizeof(NodeInt));

    third->data = 30;

    first->next = second; // This will create: 10 -> 20
    second->next = third; // This will create: 10 -> 20 -> 30
    third->next = NULL;   // This will create: 10 -> 20 -> 30 -> NULL

    printf("Linked List: ");
    NodeInt* temp = first;
  	while(temp) {
      printf("%d ", temp->data);
      temp = temp->next;
    }

    return 0;
}
