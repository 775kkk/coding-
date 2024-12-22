import heapq

def dijkstra(graph, start):
    if not graph or start not in graph:
        return None

    distances = {vertex: (float('inf'), None) for vertex in graph}
    distances[start] = (0, None)
    impotantLane = [(0, start)]

    while impotantLane:
        curr_distance, curr_vertex = heapq.heappop(impotantLane)

        if curr_distance > distances[curr_vertex][0]:
            continue

        for ryadom, weight in graph[curr_vertex]:
            distance = curr_distance + weight
            if distance < distances[ryadom][0]:
                distances[ryadom] = (distance, curr_vertex)
                heapq.heappush(impotantLane, (distance, ryadom))

    return distances

graph = {
    'A': [('B', 4), ('C', 2)],
    'B': [('A', 4), ('D', 5)],
    'C': [('A', 2), ('E', 3)],
    'D': [('B', 5), ('F', 2)],
    'E': [('C', 3), ('F', 4)],
    'F': [('D', 2), ('E', 4)]
}

def dirjkstraM(graph,start_node):
    shortest_paths = dijkstra(graph, start_node)

    if shortest_paths:
        for vertex, (distance, predecessor) in shortest_paths.items():
            print(f"кратчайший путь : от {start_node} до {vertex}: {distance}, предшественник: {predecessor}")
            path = []
            current = vertex
            while current is not None:
                path.insert(0, current)
                current = shortest_paths[current][1]
            print(f"путь: {path}")
    else:
        print("граф пуст или начальной вершины не существует.")

dirjkstraM(graph,'A')