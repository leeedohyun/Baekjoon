from sys import stdin

N = int(stdin.readline())

dp = [1, 1, 1]

for i in range(N - 1) :
    a = dp[0] + dp[1] + dp[2]
    b = dp[0] + dp[2]
    c = dp[0] + dp[1]

    dp = [a, b, c]

print(sum(dp) % 9901)