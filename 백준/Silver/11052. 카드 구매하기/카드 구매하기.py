from sys import stdin

N = int(stdin.readline())
T = [0] + list(map(int, stdin.readline().split()))

result = [0 for _ in range(N + 1)]

for i in range(1, N + 1) :
    for j in range(1, i + 1) :
        result[i] = max(result[i], result[i - j] + T[j]) 

print(result[N])