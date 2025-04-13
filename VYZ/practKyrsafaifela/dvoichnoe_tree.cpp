#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
#include <locale>

typedef struct yzelDereva{
    int data;
    struct yzelDereva *levo;
    struct yzelDereva *pravo;
}yzelDereva;

yzelDereva* createYzel(int data){
    yzelDereva *NEWyzelDereva = (yzelDereva *)malloc(sizeof(yzelDereva));
    NEWyzelDereva->data=data;
    return NEWyzelDereva;
}

// yzelDereva* createTree(int range){
//     yzelDereva *head=createYzel(1);
//     yzelDereva *temp=head;
//     for (int i = 2; i < range+1; i++)
//     {
//         while ((temp->levo!=NULL)&&(temp->pravo!=NULL))
//         {
//             if (temp->levo!=NULL)
//             {
//                 temp=head->levo;
//             }
//             if (temp->pravo!=NULL)
//             {
//                 temp=head->pravo;
//             }
//         }
//         createYzel(i);
//     }
// }
yzelDereva* insert(yzelDereva* head, int data) {
    if (head == NULL) {
        return createYzel(data);
    }
    if (data < head->data) {
        head->levo = insert(head->levo, data);
    } else if (data > head->data) {
        head->pravo = insert(head->pravo, data);
    }
    return head;
}

yzelDereva* minValueNode(yzelDereva *node) {
    yzelDereva* current = node;
    while (current && current->levo != NULL) {
        current = current->levo;
    }
    return current;
}

yzelDereva* deleteNode(yzelDereva* root, int data) {
    if (root == NULL) return root;
    
    if (data < root->data) {
        root->levo = deleteNode(root->levo, data);
    } else if (data > root->data) {
        root->pravo = deleteNode(root->pravo, data);
    } else {
        if (root->levo == NULL) {
            yzelDereva* temp = root->pravo;
            free(root);
            return temp;
        } else if (root->pravo == NULL) {
            yzelDereva* temp = root->levo;
            free(root);
            return temp;
        }
        
        yzelDereva* temp = minValueNode(root->pravo);
        root->data = temp->data;
        root->pravo = deleteNode(root->pravo, temp->data);
    }
    return root;
}

void writeNodeToFile(yzelDereva* node, FILE* file) {
    if (node != NULL) {
        writeNodeToFile(node->levo, file);
        fprintf(file, "%d ", node->data);
        writeNodeToFile(node->pravo, file);
    }
}

void writeTreeToTextFile(yzelDereva* root, const char* filename) {
    FILE* file = fopen(filename, "w");
    if (file == NULL) {
        printf("Ioeaea ioe?uoey oaeea %s\n", filename);
        return;
    }
    
    writeNodeToFile(root, file);
    fclose(file);
    printf("������������� %s\n", filename);
}

void writeBinaryNode(yzelDereva* node, FILE* file) {
    if (node != NULL) {
        fwrite(&node->data, sizeof(int), 1, file);
        writeBinaryNode(node->levo, file);
        writeBinaryNode(node->pravo, file);
    } else {
        int marker = -1;
        fwrite(&marker, sizeof(int), 1, file);
    }
}

void writeTreeToBinaryFile(yzelDereva* root, const char* filename) {
    FILE* file = fopen(filename, "wb");
    if (file == NULL) {
        printf("������������� %s\n", filename);
        return;
    }
    
    writeBinaryNode(root, file);
    fclose(file);
    printf("������������� � %s\n", filename);
}

yzelDereva* readBinaryNode(FILE* file) {
    int data;
    if (fread(&data, sizeof(int), 1, file) != 1) {
        return NULL;
    }
    
    if (data == -1) {
        return NULL;
    }
    
    yzelDereva* node = createYzel(data);
    node->levo = readBinaryNode(file);
    node->pravo = readBinaryNode(file);
    return node;
}

yzelDereva* readTreeFromBinaryFile(const char* filename) {
    FILE* file = fopen(filename, "rb");
    if (file == NULL) {
        printf("Ioeaea ioe?uoey oaeea %s\n", filename);
        return NULL;
    }
    
    yzelDereva* root = readBinaryNode(file);
    fclose(file);
    printf("������������� �  %s\n", filename);
    return root;
}

void printTree(yzelDereva* root) {
    if (root != NULL) {
        printTree(root->levo);
        printf("%d ", root->data);
        printTree(root->pravo);
    }
}

void freeTree(yzelDereva* root) {
    if (root != NULL) {
        freeTree(root->levo);
        freeTree(root->pravo);
        free(root);
    }
}

yzelDereva* createTree(int range){
    yzelDereva *head;
    for (int i = 1; i < range+1; i++) {
        head = insert(head,i);
    }
    return head;
}

yzelDereva* createTree(int* data){
    int len = sizeof(data) / sizeof(data[0]);
    yzelDereva *head;
    for (int i = 0; i < len; i++) {
        head = insert(head,data[i]);
    }
    return head;
}

int main(){


    setlocale(LC_ALL, "rus");
    yzelDereva* head = NULL;
    int elements[] = {50, 30, 70, 20, 40, 60, 80};
    int n = sizeof(elements) / sizeof(elements[0]);
    
    for (int i = 0; i < n; i++) {
        head = insert(head, elements[i]);
    }

    printf("derevo :");
    printTree(head);
    printf("\n");

    writeTreeToTextFile(head, "derevo.txt");
    
    head = insert(head, 11);// вставляем
    printf("vstavil 11 ");
    printTree(head);
    printf("\n");
    writeTreeToTextFile(head, "derevo.txt");
    
    head = deleteNode(head, 30);
    printf("delete 30: ");
    printTree(head);
    printf("\n");
    writeTreeToTextFile(head, "tree.txt");
    
    writeTreeToBinaryFile(head, "tree.bin");
    
    yzelDereva* newHead = readTreeFromBinaryFile("tree.bin");
    printf("binarnoe :");
    printTree(newHead);
    printf("\n");
    
    freeTree(head);
    freeTree(newHead);
    
}
