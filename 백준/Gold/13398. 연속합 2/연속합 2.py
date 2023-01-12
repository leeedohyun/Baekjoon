import sys

input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

sum = [[0 for _ in range(n)] for _ in range(2)]
sum[0][0] = numbers[0]
sum[1][0] = -1000

for i in range(1, n) :
    sum[0][i] = max(sum[0][i - 1] + numbers[i], numbers[i])
    sum[1][i] = max(sum[0][i - 1], sum[1][i - 1] + numbers[i])

print(max(map(max, sum)))