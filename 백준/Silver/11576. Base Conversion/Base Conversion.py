from sys import stdin
import math

A, B = map(int, stdin.readline().split())
m = int(stdin.readline())

numbers = list(map(int, stdin.readline().split()))

decimal_numbers = 0
result = []

for i in range(m):
    decimal_numbers += int(numbers[m - i - 1] * math.pow(A, i))
while decimal_numbers // B:
    result.append(decimal_numbers % B)
    decimal_numbers //= B
result.append(decimal_numbers)

print(*result[::-1])