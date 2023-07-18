def solution(board, moves):
  answer = 0
  bucket = []
  
  
  for move in moves:
    index = move - 1
    for row_info in board:
      if row_info[index] != 0:
        bucket.append(row_info[index])
        row_info[index] = 0
        
        if len(bucket) >= 2 and bucket[-1] == bucket[-2]:
          answer += 2
          bucket.pop()
          bucket.pop()
        break
         
  return answer