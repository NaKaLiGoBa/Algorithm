# Algorithm / 백준 2504: 괄호의 값


stack = [] # 스택
res = 1 # result에 더해주기 전 임시 변수
result = 0 # 결과 변수
p = list(input()) # 입력값

# 열린 괄호
for i in range(len(p)):
  if p[i]=='(':
    res *= 2
    stack.append(p[i])
    
  elif p[i]=='[':
    res *= 3
    stack.append(p[i])

# 닫힌 괄호
  elif p[i]==')':
    if not stack or stack[-1]!='(':
      result = 0
      break
    # stack이 비어있거나 맨 위의 괄호가 ( 가 아니면,
    if p[i-1]=='(': 
      result += res #결과 변수에 현재까지의 임시 변수 더해주기
    res //= 2 #임시 변수를 2로 나눠서 이전에 열린 괄호의 값(2)을 다시 되돌려주기
    # (++) 이미 여는 괄호에서 2 또는 3을 곱했고 스택에 넣어줬기 때문에 나눈다.
    stack.pop() #이전의 열린 괄호 제거, 이미짝을 맞췄으므로
    
  elif p[i]==']':
    if not stack or stack[-1]!='[':
      result = 0
      break
    if p[i-1]=='[': 
      result += res
    res //= 3
    stack.pop()

# 결과 출력
if stack:
  print(0)
else:
  print(result)
