def solution(arr):
  # num1, num2    num1 * num2 // gcd(num1, num2)
  from math import gcd
  for i in range(1, len(arr)):
    arr[i] = arr[i - 1] * arr[i] // gcd(arr[i-1], arr[i] )
    return arr[-1]