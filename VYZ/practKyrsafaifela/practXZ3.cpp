#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdbool.h>
#include <string.h>

#define MAX_VERTICES 100

// структура для представления графа
typedef struct Graph {
    int numVertices;
    int adjacencyMatrix[MAX_VERTICES][MAX_VERTICES];
    char vertexNames[MAX_VERTICES][50];
} Graph;

// инициализация графа
Graph* createGraph(int vertices) {
    Graph* graph = (Graph*)malloc(sizeof(Graph));
    graph->numVertices = vertices;
    
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
            graph->adjacencyMatrix[i][j] = 0;
        }
        sprintf(graph->vertexNames[i], "Vertex%d", i);
    }
    
    return graph;
}

// добавление вершины
void addVertex(Graph* graph, const char* name) {
    if (graph->numVertices >= MAX_VERTICES) {
        printf("the maximum number of vertices has been reached\n");
        return;
    }
    
    strcpy(graph->vertexNames[graph->numVertices], name);
    for (int i = 0; i <= graph->numVertices; i++) {
        graph->adjacencyMatrix[graph->numVertices][i] = 0;
        graph->adjacencyMatrix[i][graph->numVertices] = 0;
    }
    graph->numVertices++;
}

// удаление вершины
void removeVertex(Graph* graph, int vertex) {
    if (vertex < 0 || vertex >= graph->numVertices) {
        printf("invalid vertex index\n");
        return;
    }
    
    // сдвигаем вершины в массиве
    for (int i = vertex; i < graph->numVertices - 1; i++) {
        strcpy(graph->vertexNames[i], graph->vertexNames[i+1]);
        for (int j = 0; j < graph->numVertices; j++) {
            graph->adjacencyMatrix[i][j] = graph->adjacencyMatrix[i+1][j];
        }
        for (int j = 0; j < graph->numVertices; j++) {
            graph->adjacencyMatrix[j][i] = graph->adjacencyMatrix[j][i+1];
        }
    }
    graph->numVertices--;
}

// добавление ребра
void addEdge(Graph* graph, int src, int dest, int weight) {
    if (src >= 0 && src < graph->numVertices && dest >= 0 && dest < graph->numVertices) {
        graph->adjacencyMatrix[src][dest] = weight;
        graph->adjacencyMatrix[dest][src] = weight; // для неориентированного графа
    }
}

//уудаление ребра
void removeEdge(Graph* graph, int src, int dest) {
    if (src >= 0 && src < graph->numVertices && dest >= 0 && dest < graph->numVertices) {
        graph->adjacencyMatrix[src][dest] = 0;
        graph->adjacencyMatrix[dest][src] = 0; // для неориентированного графа
    }
}

// вывод смежных вершин
void printAdjacentVertices(Graph* graph) {
    printf(" peaks:\n");
    for (int i = 0; i < graph->numVertices; i++) {
        printf("%s: ", graph->vertexNames[i]);
        for (int j = 0; j < graph->numVertices; j++) {
            if (graph->adjacencyMatrix[i][j] != 0) {
                printf("%s(%d) ", graph->vertexNames[j], graph->adjacencyMatrix[i][j]);
            }
        }
        printf("\n");
    }
}

// поиск в глубину(DFS)
void DFS(Graph* graph, int vertex, bool visited[]) {
    visited[vertex] = true;
    printf("%s ", graph->vertexNames[vertex]);
    
    for (int i = 0; i < graph->numVertices; i++) {
        if (graph->adjacencyMatrix[vertex][i] != 0 && !visited[i]) {
            DFS(graph, i, visited);
        }
    }
}

void depthFirstSearch(Graph* graph, int startVertex) {
    bool visited[MAX_VERTICES] = {false};
    printf("depth-first search (DFS) starting from %s:", graph->vertexNames[startVertex]);
    DFS(graph, startVertex, visited);
    printf("\n");
}

// поиск в ширину (BFS)
void breadthFirstSearch(Graph* graph, int startVertex) {
    bool visited[MAX_VERTICES] = {false};
    int queue[MAX_VERTICES];
    int front = 0, rear = 0;
    
    visited[startVertex] = true;
    queue[rear++] = startVertex;
    
    printf("breadthfirst search (BFS) starting from %s:", graph->vertexNames[startVertex]);
    
    while (front < rear) {
        int currentVertex = queue[front++];
        printf("%s ", graph->vertexNames[currentVertex]);
        
        for (int i = 0; i < graph->numVertices; i++) {
            if (graph->adjacencyMatrix[currentVertex][i] != 0 && !visited[i]) {
                visited[i] = true;
                queue[rear++] = i;
            }
        }
    }
    printf("\n");
}

// агоритм Дейкстры
void dijkstra(Graph* graph, int startVertex) {
    int dist[MAX_VERTICES];
    bool visited[MAX_VERTICES];
    
    for (int i = 0; i < graph->numVertices; i++) {
        dist[i] = INT_MAX;
        visited[i] = false;
    }
    
    dist[startVertex] = 0;
    
    for (int count = 0; count < graph->numVertices - 1; count++) {
        int minDist = INT_MAX, minIndex;
        
        for (int v = 0; v < graph->numVertices; v++) {
            if (!visited[v] && dist[v] <= minDist) {
                minDist = dist[v];
                minIndex = v;
            }
        }
        
        visited[minIndex] = true;
        
        for (int v = 0; v < graph->numVertices; v++) {
            if (!visited[v] && graph->adjacencyMatrix[minIndex][v] && 
                dist[minIndex] != INT_MAX && 
                dist[minIndex] + graph->adjacencyMatrix[minIndex][v] < dist[v]) {
                dist[v] = dist[minIndex] + graph->adjacencyMatrix[minIndex][v];
            }
        }
    }
    
    printf("shortest distance from the top %s:\n", graph->vertexNames[startVertex]);
    for (int i = 0; i < graph->numVertices; i++) {
        if (dist[i] == INT_MAX) {
            printf("%s: unreachable\n", graph->vertexNames[i]);
        } else {
            printf("%s: %d\n", graph->vertexNames[i], dist[i]);
        }
    }
}

// пересоздание графа на основе обхода в ширину
Graph* recreateGraphFromBFS(Graph* originalGraph, int startVertex) {
    bool visited[MAX_VERTICES] = {false};
    int order[MAX_VERTICES]; // Порядок обхода BFS
    int orderIndex = 0;
    
    // Стандартный BFS
    int queue[MAX_VERTICES];
    int front = 0, rear = 0;
    
    visited[startVertex] = true;
    queue[rear++] = startVertex;
    order[orderIndex++] = startVertex;
    
    while (front < rear) {
        int current = queue[front++];
        
        for (int i = 0; i < originalGraph->numVertices; i++) {
            if (originalGraph->adjacencyMatrix[current][i] && !visited[i]) {
                visited[i] = true;
                queue[rear++] = i;
                order[orderIndex++] = i;
            }
        }
    }
    printf("BFS vertex order: ");
    for (int i = 0; i < orderIndex; i++) {
        printf("%s ", originalGraph->vertexNames[order[i]]);
    }
    printf("\n");
    // Создаём новый граф с вершинами в порядке BFS
    Graph* newGraph = createGraph(orderIndex);
    
    // Копируем имена в новом порядке
    for (int i = 0; i < orderIndex; i++) {
        strcpy(newGraph->vertexNames[i], originalGraph->vertexNames[order[i]]);
    }
    
    // Копируем рёбра с учётом нового порядка
    // for (int i = 0; i < orderIndex; i++) {
    //     for (int j = 0; j < orderIndex; j++) {
    //         newGraph->adjacencyMatrix[i][j] =originalGraph->adjacencyMatrix[order[i]][order[j]];
    //     }
    // }
    for (int i = 1; i < orderIndex; i++) {
    int parent = order[i-1]; // Предыдущая вершина в BFS-очереди
    int current = order[i];
    if (originalGraph->adjacencyMatrix[parent][current] != 0) {
        addEdge(newGraph, i-1, i, originalGraph->adjacencyMatrix[parent][current]);
    }
}
    
    return newGraph;
}

// таблица связности
void printConnectivityTable(Graph* graph) {
    printf("connectivity table:\n");
    
    for (int i = 0; i < graph->numVertices; i++) {
        bool visited[MAX_VERTICES] = {false};
        int queue[MAX_VERTICES];
        int front = 0, rear = 0;
        
        visited[i] = true;
        queue[rear++] = i;
        
        while (front < rear) {
            int currentVertex = queue[front++];
            
            for (int j = 0; j < graph->numVertices; j++) {
                if (graph->adjacencyMatrix[currentVertex][j] != 0 && !visited[j]) {
                    visited[j] = true;
                    queue[rear++] = j;
                }
            }
        }
        
        printf("%s: ", graph->vertexNames[i]);
        for (int j = 0; j < graph->numVertices; j++) {
            if (visited[j]) {
                printf("%s ", graph->vertexNames[j]);
            }
        }
        printf("\n");
    }
}

int main() {
    // cоздаем 
    Graph* graph = createGraph(5);
    strcpy(graph->vertexNames[0], "A");
    strcpy(graph->vertexNames[1], "B");
    strcpy(graph->vertexNames[2], "C");
    strcpy(graph->vertexNames[3], "D");
    strcpy(graph->vertexNames[4], "E");
    
    // lобавляем ребр
    addEdge(graph, 0, 1, 4);
    addEdge(graph, 0, 2, 2);
    addEdge(graph, 1, 2, 1);
    addEdge(graph, 1, 3, 5);
    addEdge(graph, 2, 3, 8);
    addEdge(graph, 2, 4, 10);
    addEdge(graph, 3, 4, 2);
    
    // 1) вывод смежных вершин
    printAdjacentVertices(graph);
    printf("\n");
    
    // 2) алгоритмы поиска
    depthFirstSearch(graph, 0);
    breadthFirstSearch(graph, 0);
    dijkstra(graph, 0);
    printf("\n");
    
    // 3) пересоздание графа на основе BFS
    printf("re-creating a graph based on BFS:\n");
    Graph* newGraph = recreateGraphFromBFS(graph, 0);
    printAdjacentVertices(newGraph);
    printf("\n");
    
    // 4) таблица связности
    printConnectivityTable(graph);
    printf("\n");
    
    // добавление и удаление вершин/ребер
    printf("adding vertex F and edge E-F:\n");
    addVertex(graph, "F");
    addEdge(graph, 4, 5, 3);
    printAdjacentVertices(graph);
    printf("\n");
    
    printf("removing the edge B-C:\n");
    removeEdge(graph, 1, 2);
    printAdjacentVertices(graph);
    printf("\n");
    
    printf("deleting vertex C:\n");
    removeVertex(graph, 2);
    printAdjacentVertices(graph);
    printf("\n");
    
    free(graph);
    free(newGraph);
}