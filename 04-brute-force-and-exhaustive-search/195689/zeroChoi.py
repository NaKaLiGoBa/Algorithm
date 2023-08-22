# 구해야 할 것 값이 k인 깃발의 "개수"


N, K = map(int, input().split())

game_board = []
for _ in range(N):
    row = list(map(int, input().split()))
    game_board.append(row)


# 8방향을 나타내는 좌표 변화값
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

# 값이 K인 깃발의 개수를 세는 변수
flag_count = 0

for r in range(N):
    for c in range(N):
        if game_board[r][c] == 0:
            cloud_count = 0  # 주변 구름의 개수를 저장할 변수 = 깃발
            for i in range(8):
                nr = r + dx[i]  # 변화량을 통해 새로운 이동 인덱스 저장
                nc = c + dy[i]
                if 0 <= nr < N and 0 <= nc < N and game_board[nr][nc] == 1:
                    cloud_count += 1
            if cloud_count == K:  # 주변 구름 개수가 K와 일치하면
                flag_count += 1

# 결과 출력
print(flag_count)
