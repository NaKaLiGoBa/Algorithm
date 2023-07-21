from collections import deque

num = int(input())
for i in range(num):
    cnt = 0 #결과값
    N, M = map(int,input().split())
    imp = deque(list(map(int,input().split())))
    #중요도 리스트 디큐로 변환
    
    while len(imp) > 0:
        maxi = max(imp)
        if imp[0] == maxi:  # 처음 원소값이 최댓값이면
            imp.popleft()
            if M == 0:  # pop된 수가 목표 수이면
                cnt += 1
                break
            else:
                cnt += 1
                M -= 1  # 한칸씩 당겨짐
        else:
            a = imp.popleft()
            imp.append(a)
            if M == 0:
                M += len(imp) - 1  # 목표 수가 최대값이 아니면 맨 뒤로 넣어줌
            else:
                M -= 1 
    print(cnt)