from sys import stdin

input = stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

sum = [numbers[0]]

for i in range(1, n) :
    if sum[i - 1] > 0 :
        sum.append(sum[i - 1] + numbers[i])
    else :
        sum.append(numbers[i])

print(max(sum))