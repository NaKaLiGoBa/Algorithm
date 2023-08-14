n = int(input())  # 사람 수
a, b = map(int, input().strip().split())  # 시작 사람과 목표 사람
m = int(input())  # 관계 수

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    x, y = map(int, input().strip().split())
    graph[x].append(y)
    graph[y].append(x)  # 양방향 그래프

visited = [False] * (n + 1)

def dfs(start, chon):
    visited[start] = True
    
    if start == b: # 목표 사람에 도달하면 촌수를 반환
        print(chon)
        return True # 찾았다는 표시로 True 반환
    
    for neighbor in graph[start]:
        if not visited[neighbor]:
            if dfs(neighbor, chon + 1): # 인접한 사람에 대해 재귀 호출
                return True

if not dfs(a, 0): # 시작 사람과 촌수 0으로 DFS 시작
    print(-1) # 목표 사람을 찾지 못하면 -1 출력
