n = int(input())
s = input().strip()

# 문자열을 3등분하는 경우의 문자열을 저장할 리스트
arr = []

# 모든 3등분의 경우를 검사
for i in range(1, n-1):
    for j in range(i+1, n):
        part1 = s[:i]
        part2 = s[i:j]
        part3 = s[j:]
        arr.append([part1, part2, part3])

# 중복되지 않는 문자열들을 사전순으로 정렬
p_list = sorted(list(set([p for parts in arr for p in parts])))

# 최대 점수를 저장할 변수
max_score = 0

# 각 문자열 3등분의 경우에 대해 점수를 계산하고 최대 점수를 찾는다
for parts in arr:
    score = sum([p_list.index(part) + 1 for part in parts])
    max_score = max(max_score, score)

print(max_score)  # 최대 점수 출력
