import sys
input = sys.stdin.readline

N = int(input())
colors = [list(map(int,input().split())) for _ in range(N)]
result, inf = 1e9, 1e9

for color in range(3): # 첫 집의 색상
    dp = [[0 for _ in range(3)] for __ in range(N)]
    for i in range(3):
        if i == color:
            dp[0][i] = colors[0][i]
        else:
            dp[0][i] = inf
    for i in range(1, N):
        dp[i][0] = colors[i][0] + min(dp[i-1][1],dp[i-1][2])
        dp[i][1] = colors[i][1] + min(dp[i-1][0],dp[i-1][2])
        dp[i][2] = colors[i][2] + min(dp[i-1][0],dp[i-1][1])

    for i in range(3):
        if i != color:
            result = min(result, dp[-1][i])
print(result)