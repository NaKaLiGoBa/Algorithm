def solution(numbers, target):
  answer = 0
  
  def dfs (idx , sum_result):
    nonlocal answer
    
    
    #1. 탈출조건
    if idx == len(numbers) :
      if target == sum_result :
        answer += 1
        return answer
      
      
    #2. 수행 동작
    else :
      dfs(idx+1, sum_result + numbers[idx])
      dfs(idx+1, sum_result - numbers[idx])
      
      
      
  dfs(0,0)
  
  
  return answer     