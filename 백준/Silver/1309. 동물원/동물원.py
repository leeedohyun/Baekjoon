from sys import stdin

N = int(stdin.readline())

dp = [3, 7]

for i in range(2, N):
    a = (dp[0] + dp[1] * 2) % 9901

    dp = [dp[1], a]

if N == 1 :
    print(dp[0])
else :
    print(dp[1])