from collections import deque

def shir(graph, start):# в ширину
    visited = set()
    queue = deque([start])
    visited.add(start)
    shir_order = []
    while queue:
        vertex = queue.popleft()
        shir_order.append(vertex)
        for neighbor in graph.get(vertex, []): # Обработка отсутствующих
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)

    return shir_order



def glub(graph, start, visited=None, glub_order=None):# в глубину
    if visited is None:
        visited = set()
    if glub_order is None:
        glub_order = []

    visited.add(start)
    glub_order.append(start)

    for neighbor in graph.get(start, []):
        if neighbor not in visited:
            glub(graph, neighbor, visited, glub_order)

    return glub_order

graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': ['F'],
    'F': []
}

shir_result = shir(graph, 'A')
print("в шир :", shir_result) # Вывод: BFS: ['A', 'B', 'C', 'D', 'E', 'F']

glub_result = glub(graph, 'A')
print("в глуб:", glub_result) # Вывод: DFS: ['A', 'B', 'D', 'E', 'F', 'C'] (порядок может меняться в зависимости от реализации)

#Пример с обработкой отсутствующих
graph_with_missing_key = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': ['F', 'G'], #G нет в графе
    'F': []
}

shir_result = shir(graph_with_missing_key, 'A')
print("в шир 2:", shir_result) # Вывод: BFS: ['A', 'B', 'C', 'D', 'E', 'F', 'G']

glub_result = glub(graph_with_missing_key, 'A')
print("в глуб 2:", glub_result) # Вывод: DFS: ['A', 'B', 'D', 'E', 'F', 'C']


import heapq

def dijkstra(graph, start):
    if not graph or start not in graph:
        return None
    distance = {versh: (float('inf'), None) for versh in graph} #расстояния и предшественники
    distance[start] = (0, None) #расстояние до начальной вершины равно 0
    priority_queue = [(0, start)] #очередь с приоритетом (расстояние, вершина)

    while priority_queue:
        curr_dist, curr_versh = heapq.heappop(priority_queue)

        if curr_dist > distance[curr_versh][0]:
            continue #если нашли путь длиннее

        for ryadom, weight in graph[curr_versh].items():
            distance = curr_dist + weight
            if distance < distance[ryadom][0]:
                distance[ryadom] = (distance, curr_versh)
                heapq.heappush(priority_queue, (distance, ryadom))
    # return distance
    while priority_queue:
        current_distance, current_vertex = heapq.heappop(priority_queue)

        if current_distance > distance[current_vertex][0]:
            continue

        for ryadom_and_weight in graph[current_vertex]: # Изменение здесь
            ryadom, weight = ryadom_and_weight # Распаковка кортежа
            distance = current_distance + weight
            if distance < distance[ryadom][0]:
                distance[ryadom] = (distance, current_vertex)
                heapq.heappush(priority_queue, (distance, ryadom))

    return distance



graph = {
    'A': [('B', 4), ('C', 2)],
    'B': [('A', 4), ('D', 5)],
    'C': [('A', 2), ('E', 3)],
    'D': [('B', 5), ('F', 2)],
    'E': [('C', 3), ('F', 4)],
    'F': [('D', 2), ('E', 4)]
}


shortest_paths = dijkstra(graph, 'A')

if shortest_paths:
    for vertex, (distance, predecessor) in shortest_paths.items():
        print(f"Кратчайший путь от 'A' до {vertex}: {distance}, предшественник: {predecessor}")
        path = []
        current = vertex
        while current is not None:
            path.insert(0, current)
            current = shortest_paths[current][1]
        print(f"Путь: {path}")

else:
    print("Граф пустой или начальной вершины не существует.")



print("в глуб 2:", dijkstra(graph_with_missing_key, 'A'))