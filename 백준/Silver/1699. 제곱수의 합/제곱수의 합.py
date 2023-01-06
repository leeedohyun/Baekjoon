# 내가 푼 풀이
N = int(input())

dp = [i for i in range(N + 1)]

for i in range(1, N + 1) :
    for j in range(1, i) :
        if j * j > i :
            break
        if dp[i] > dp[i - j * j] + 1 :
            dp[i] = dp[i - j * j] + 1
        
print(dp[N])

# 효율적인 풀이 : 메모리(30616 KB), 시간(44 ms)
sq = [i * i for i in range(1, 320)]

N = int(input())

if N in sq: print(1)
else:
    for i in sq:
        for j in sq:
            if i + j == N: print(2); exit()
    while N % 4 == 0:
        N //= 4
    if N % 8 == 7: print(4)
    else: print(3)
