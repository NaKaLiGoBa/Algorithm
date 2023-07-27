import sys
input=sys.stdin.readline

N,M = map(int,input().split())

board = []

# 배열 입력
for _ in range(N) :
  board.append(list(input()))
  
  
#배열을 int형으로 선언
board[0][0] = 1

#상하좌우
dx = [-1,1,0,0]
dy = [0,0,-1,1]

queue = [[0,0]] #시작 좌표

#BFS

while queue :
  x, y = queue[0][0], queue[0][1]
  
  del queue [0]
  
  for i in range(4) :
    nx = x + dx[i]
    ny = y + dy [i]
    
    if nx >= 0 and ny >= 0 and nx < N and ny < M :
      if board[nx][ny] == '1' :
        queue.append([nx,ny])
        board[nx][ny] = board[x][y] + 1
        
print(board[N-1][M-1])