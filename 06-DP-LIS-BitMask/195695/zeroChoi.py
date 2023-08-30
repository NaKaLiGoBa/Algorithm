from collections import deque, defaultdict

N, K = map(int, input().split())
m = [list(map(int, input().split())) for _ in range(N)]
v = [[False]*N for _ in range(N)]
b_count = defaultdict(int)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(x, y):
    if v[x][y]:
        return
    v[x][y] = True
    q = deque([(x, y)])
    t = m[x][y]
    cnt = 1

    while q:
        cx, cy = q.popleft()

        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not v[nx][ny] and m[nx][ny] == t:
                v[nx][ny] = True
                q.append((nx, ny))
                cnt += 1

    if cnt >= K:
        b_count[t] += 1


for i in range(N):
    for j in range(N):
        bfs(i, j)

ans_type = max(b_count, key=lambda k: (b_count[k], k))
print(ans_type)
