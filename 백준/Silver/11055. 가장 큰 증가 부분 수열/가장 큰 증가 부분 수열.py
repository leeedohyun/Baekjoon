# 내가 푼 풀이
import sys

input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))

dp = [1] * n
dp[0] = A[0]

for i in range(1, n) :
    for j in range(i) :
        if A[i] > A[j] :
            dp[i] = max(dp[i], dp[j] + A[i])
        else :
            dp[i] = max(dp[i], A[i])

print(max(dp))

# 조금 더 효율적인 풀이 : 시간 (44 ms)
input()
dp = [0] * 1001
for i in map(int, input().split()):
    dp[i] = max(dp[:i]) + i         # 입력한 리스트의 요소들을 인덱스로 놓고 인덱스보다 작은 값 중 최댓값과 자기 자신을 더한 값을 저장
    
print(max(dp))
