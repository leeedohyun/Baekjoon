from sys import stdin

input = stdin.readline

N = int(input())
dp = [[0] * 3 for _ in range(N)]

for i in range(N) :
    cost = list(map(int, input().split()))

    dp[i][0] = min(dp[i - 1][1] + cost[0], dp[i - 1][2] + cost[0])
    dp[i][1]= min(dp[i - 1][2] + cost[1], dp[i - 1][0] + cost[1])
    dp[i][2]= min(dp[i - 1][0] + cost[2], dp[i - 1][1] + cost[2]) 

print(min(dp[N - 1]))