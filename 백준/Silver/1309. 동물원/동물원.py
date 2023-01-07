# 내가 푼 풀이 : 이전의 행에 사자가 없는 경우, 왼쪽인 경우, 오른쪽인 경우로 나누어서 계산
# 시간 : 820 ms
from sys import stdin

N = int(stdin.readline())

dp = [1, 1, 1]

for i in range(N - 1) :
    a = dp[0] + dp[1] + dp[2]
    b = dp[0] + dp[2]
    c = dp[0] + dp[1]

    dp = [a, b, c]

print(sum(dp) % 9901)

# 효율적인 풀이
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
