DX = [0, 0, 0, -1, 1]
DY = [0, -1, 1, 0, 0]

n, k = map(int, input().split())
board = [input().split() for _ in range(n)]
score = [[0] * n for _ in range(n)]
answer = 0

for _ in range(k):
    y, x = map(int, input().split())
    y -= 1
    x -= 1

    for i in range(5):
        ny, nx = y + DY[i], x + DX[i]

        if 0 <= ny < n and 0 <= nx < n:
            if board[ny][nx] == "0":
                score[ny][nx] += 1
            elif board[ny][nx] == "@":
                score[ny][nx] += 2
            elif board[ny][nx] == "#":
                score[ny][nx] += 0
            answer = max(answer, score[ny][nx])

print(answer)
