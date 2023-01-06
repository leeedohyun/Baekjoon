from sys import stdin

input = stdin.readline

N, K = map(int, input().split())

dp = [[0 for x in range(K + 1)] for y in range(N + 1)]
dp[1] = [x for x in range(K + 1)]


for i in range(2, N + 1) :
    dp[i][1] = 1
    for j in range(2, K + 1) :
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j]

print(dp[N][K] % 1000000000)