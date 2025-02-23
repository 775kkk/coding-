#include <stdio.h>

#define MAX_NODES 100

typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node nodes[MAX_NODES];
int nodeCount = 0;

Node* createNode(int data) {
    if (nodeCount >= MAX_NODES) {
        printf("Error: Maximum number of nodes reached.\n");
        return NULL;
    }
    nodes[nodeCount].data = data;
    nodes[nodeCount].next = NULL;
    return &nodes[nodeCount++];
}

Node* insertAtEnd(Node* head, int data) {
    Node* newNode = createNode(data);
    if (newNode == NULL) {
        return head;
    }
    if (head == NULL) {
        return newNode;
    }
    Node* temp = head;
    while (temp->next) {
        temp = temp->next;
    }
    temp->next = newNode;
    return head;
}

Node* insertAtBeginning(Node* head, int data) {
    Node* newNode = createNode(data);
    if (newNode == NULL) {
        return head;
    }
    newNode->next = head;
    return newNode;
}

Node* insertAtPosition(Node* head, int data, int position) {
    if (position < 0) {
        printf("Invalid position!\n");
        return head;
    }
    if (position == 0) {
        return insertAtBeginning(head, data);
    }
    Node* newNode = createNode(data);
    if (newNode == NULL) {
        return head;
    }
    Node* temp = head;
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

Node* insertAtElement(Node* head, int data, int element) {
    Node* newNode = createNode(data);
    if (newNode == NULL) {
        return head;
    }
    if (head == NULL) {
        return newNode;
    }
    Node* temp = head;
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
Node* deliteSpisok(Node* head) {
    Node* temp = head;
    while (temp) {
        Node* next = temp->next;
        delete temp;
        temp = next;
    }
    return NULL;
}   

int main() {
    Node* head = NULL;

    head = insertAtEnd(head, 10);
    head = insertAtEnd(head, 20);
    head = insertAtEnd(head, 30);

    printf("Linked List: ");
    Node* temp = head;
    while (temp) {
        printf("%d ", temp->data);
        temp = temp->next;
    }

    return 0;
}