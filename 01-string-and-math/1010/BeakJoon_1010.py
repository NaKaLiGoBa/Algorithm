# def factorial(n):
#     num = 1
#     for i in range(1, n+1):
#         num *= i
#     return num

import math

T = int(input())

for _ in range(T):
    n, m = map(int, input().split())
    bridge = math.factorial(m) // (math.factorial(n) * math.factorial(m - n))
    print(bridge)