import sys
input = sys.stdin.readline

N = int(input())
stick_list = [] # 막대기 높이 저장 
for _ in range(N):
    stick_list.append(int(input()))

answer = 0 #최종 출력 값
stack = [] 
for stick in reversed(stick_list):
    if stack:
        if stack[-1] < stick:
            stack.pop()
            stack.append(stick)
            answer += 1
    else:
        stack.append(stick)
        answer += 1

print(answer)