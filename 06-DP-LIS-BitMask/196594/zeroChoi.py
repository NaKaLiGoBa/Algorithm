from collections import deque

N = int(input())
grid = [list(map(int, input().split())) for _ in range(N)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

visited = [[False]*N for _ in range(N)]


def bfs(x, y):
    q = deque([(x, y)])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                visited[nx][ny] = True
                if grid[nx][ny] == 1:
                    q.append((nx, ny))


count = 0
for i in range(N):
    for j in range(N):
        if grid[i][j] == 1 and not visited[i][j]:
            count += 1
            visited[i][j] = True
            bfs(i, j)

print(count)
