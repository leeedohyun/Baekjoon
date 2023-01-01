from sys import stdin
input = stdin.readline

N = int(input())
P = [0] + list(map(int, input().split()))

result = [0] + [10001] * N 

for i in range(1, N + 1) :
    for j in range(1, i + 1) :
        result[i] = min(result[i], result[i - j] + P[j])

print(result[N])