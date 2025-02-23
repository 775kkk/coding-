// C Program to create a Linked List
#include <stdio.h>
#include <stdlib.h>

// Define the structure of Node
typedef struct Node {
  
    // Data field. Can add more data according to our need
    int data;

    // Pointer to the next node
    struct Node *next;
} Node;

Node* createNode(int data) {
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}
Node* insertAtEnd(Node *head, int data) {
    Node *newNode = createNode(data);
    if (head == NULL) {
        return newNode;
    }
    Node *temp = head;
    while (temp->next) {
        temp = temp->next;
    }
    temp->next = newNode;
    return head;
}
Node* insertAtBeginning(Node *head, int data) {
    Node *newNode = createNode(data);
    newNode->next = head;
    return newNode;
}
Node* insertAtPosition(Node *head, int data, int position) {
    if (position < 0) {
        printf("Invalid position!\n");
        return head;
    }
    if (position == 0) {
        return insertAtBeginning(head, data);
    }
    Node *newNode = createNode(data);
    Node *temp = head;
    while (position > 1) {
        if (temp == NULL) {
            printf("Invalid position!\n");
            return head;
        }
        temp = temp->next;
        position--;
    }
    newNode->next = temp->next;
    temp->next = newNode;
    return head;
}
Node* insertAtElement(Node *head, int data, int element) {
    Node *newNode = createNode(data);
    if (head == NULL) {
        return newNode;
    }
    Node *temp = head;
    while (temp->data != element) {
        temp = temp->next;
        if (temp == NULL) {
            printf("Element not found!\n");
            return head;
        }
    }
    newNode->next = temp->next;
    temp->next = newNode;
    return head;
}

int main() {
    Node *first = (Node *)malloc(sizeof(Node));
 
    first->data = 10;

    Node *second = (Node *)malloc(sizeof(Node));

    second->data = 20;

    Node *third = (Node *)malloc(sizeof(Node));

    third->data = 30;

    first->next = second; // This will create: 10 -> 20
    second->next = third; // This will create: 10 -> 20 -> 30
    third->next = NULL;   // This will create: 10 -> 20 -> 30 -> NULL

    printf("Linked List: ");
    Node* temp = first;
  	while(temp) {
      printf("%d ", temp->data);
      temp = temp->next;
    }

    return 0;
}
