import sys

input = sys.stdin.readline

N = int(input())
P = list(map(int, input().split()))

P.sort()

min = 0
sum = 0
for p in P :
    sum += p
    min += sum

print(min)