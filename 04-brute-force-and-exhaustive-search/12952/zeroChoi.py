def promising(i, col):      # 대각선 방향 겹치는지 체크
    k = 1
    flag = True
    while k < i and flag:
        if col[i] == col[k] or (abs(col[i]-col[k]) == i-k):
            flag = False
        k += 1
    return flag

def nqueen(i,n,col):    # 같은 행, 같은 열인지
    global ans
    if promising(i, col):
        if i == n:
            ans += 1
        else:
            for j in range(1, n+1):
                col[i+1] = j
                nqueen(i+1, n, col)
    return ans

ans = 0
def solution(n):
    col = [0] * (n + 1)
    return nqueen(0,n,col)
