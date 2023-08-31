
N, M, K = map(int, input().split())
graph = [[] for _ in range(N + 1)]


for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 간선 정보, 인접 리스트 구성, 양쪽 노드 정보
for edges in graph:
    edges.sort()


visited = set()
last_node = K


current_node = K

while True:

    visited.add(current_node)

    found = False
    for neighbor in graph[current_node]:
        if neighbor not in visited:
            last_node = neighbor
            current_node = neighbor
            found = True
            break

    if not found:
        break

# 결과 출력
print(len(visited), last_node)
