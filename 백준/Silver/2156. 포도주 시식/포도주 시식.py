import sys

input = sys.stdin.readline

n = int(input())

dp = [[0 for _ in range(3)] for _ in range(10001)]

for i in range(1, n + 1) :
    amount = int(input())

    dp[i][0] = max(dp[i - 1])
    dp[i][1] = max(dp[i - 1][0] + amount, dp[i - 2][2] + amount)
    dp[i][2] = dp[i - 1][1] + amount

print(max(dp[n]))