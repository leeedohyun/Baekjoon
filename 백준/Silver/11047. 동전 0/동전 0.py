import sys

input = sys.stdin.readline

N, K = map(int, input().split())
coin = []
result = 0

for i in range(N) :
    coin.append(int(input()))

for i in range(N - 1, -1, -1) :
    result += (K // coin[i])
    K %= coin[i]

print(result)