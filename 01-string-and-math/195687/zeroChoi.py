def count_ones(number):
    return bin(number)[2:].count('1')


N, K = map(int, input().strip().split())
numbers = list(map(int, input().strip().split()))

# (1의 개수, 원래 숫자) 형태로 저장
numbers_with_count = [(count_ones(number), number) for number in numbers]

# '1'의 개수로 내림차순 정렬, '1'의 개수가 같다면 원래 숫자로 내림차순 정렬
sorted_numbers = sorted(
    numbers_with_count, key=lambda x: (x[0], x[1]), reverse=True)

# K번째 숫자 출력
result = sorted_numbers[K-1][1]
print(result)


# 입력받은 정수를 이진수로 변환, 내림차순
