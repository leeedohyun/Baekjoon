from sys import stdin

input = stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

sum = [numbers[0]]

for i in range(n - 1) :
    sum.append(max(sum[i] + numbers[i + 1], numbers[i + 1]))

print(max(sum))