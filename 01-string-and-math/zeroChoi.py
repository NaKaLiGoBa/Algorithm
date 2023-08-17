N = int(input())  # 재료의 개수 입력 받기
tastes = list(map(int, input().strip().split()))

peak_index = tastes.index(max(tastes))  # 가장 높은 맛의 정도의 인덱스 찾기


for i in range(1, peak_index):
    if tastes[i] < tastes[i - 1]:  # 이전 재료보다 맛이 작으면
        print(0)  # 규칙을 어긴 경우 0 출력하고 종료
        exit()


for i in range(peak_index + 1, N):
    if tastes[i] > tastes[i - 1]:
        print(0)  # 규칙을 어긴 경우 0 출력하고 종료
        exit()

print(sum(tastes))  # 모든 규칙을 따르면 햄버거의 맛의 정도 합계 출력
