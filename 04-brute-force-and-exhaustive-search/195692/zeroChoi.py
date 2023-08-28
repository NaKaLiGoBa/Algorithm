N = int(input())

# 구름이와 플레이어의 위치 입력
Rg, Cg = map(int, input().split())
Rp, Cp = map(int, input().split())

# 보드 정보 입력
board = []
for _ in range(N):
    row_data = input().split()
    row = [(data[:-1], data[-1]) for data in row_data]
    board.append(row)

directions = {
    "U": (-1, 0),  # 위로 1칸
    "D": (1, 0),   # 아래로 1칸
    "R": (0, 1),   # 오른쪽으로 1칸
    "L": (0, -1)   # 왼쪽으로 1칸
}


def play_game(initial_position):
    row, col = initial_position[0] - 1, initial_position[1] - 1
    score = 0

    score += 1
    visited[row][col] = True

    while True:
        count, direction = board[row][col]
        dr, dc = directions[direction]
        for _ in range(int(count)):
            row = (row + dr) % N
            col = (col + dc) % N

            if visited[row][col]:
                return score
            score += 1
            visited[row][col] = True

    return score


visited = [[False for _ in range(N)] for _ in range(N)]
goorm_score = play_game((Rg, Cg))

visited = [[False for _ in range(N)] for _ in range(N)]
player_score = play_game((Rp, Cp))

if goorm_score > player_score:
    print("goorm", goorm_score)
else:
    print("player", player_score)
