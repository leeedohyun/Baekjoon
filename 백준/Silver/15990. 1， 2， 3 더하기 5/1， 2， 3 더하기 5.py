# 내가 푼 풀이
from sys import stdin

input = stdin.readline

T = int(input())

result = [[0 for j in range(3)] for i in range(100001)]
result[1] = [1, 0, 0]
result[2] = [0, 1, 0]
result[3] = [1, 1, 1]

for i in range(4, 100001) :
    result[i][0] = (result[i - 1][1] + result[i - 1][2]) % 1000000009
    result[i][1] = (result[i - 2][0] + result[i - 2][2]) % 1000000009
    result[i][2] = (result[i - 3][0] + result[i - 3][1]) % 1000000009

for i in range(T):
    n = int(input())

    print(sum(result[n]) % 1000000009)
    
# 메모리: 34272 KB, 시간: 136 ms
import sys
input = sys.stdin.readline

mod = 1_000_000_009
dp = [0,1,1,3] + [0]*99997
a = [1, 0, 0]
b = [0, 1, 0]
c = [1, 1, 1]
for i in range(4,100001):
    temp = [(c[1]+c[2])%mod, (b[0]+b[2])%mod, (a[0]+a[1])%mod]
    a, b, c = b, c, temp
    dp[i] = sum(c)%mod

test_case = int(input())
for _ in range(test_case):
    print(dp[int(input())])
