'''
수정하기 전 : order이 1부터 증가하는 순으로 구하려고 해본 결과 틀림
------- 이유 --------
order를 증가시키면서 구할 경우에는 dp가 연속으로 같은 결과가 나왔을 때 잘못된 결과가 나온다.
3 1 2 1 2 를 입력한 경우에 
dp = [1, 1, 2, 1, 2]가 나오므로
order = 1인 경우 dp[0]를 인덱스로 가지는 3을 선택하고
order = 2인 경우 dp[2]를 인덱스로 가지는 2를 선택하게 되어 결과가 감소한다.]
그래서 order을 감소시키면서 큰 값부터 구하면 된다고 판단했다.
'''
import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

dp = [1] * N

for i in range(1, N) :
    for j in range(i) :
        if A[i] > A[j] :
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))

result = []
order =  min(dp)
for i in range(N) :
        if dp[i] == order :
            result.append(A[i])
            order += 1

print(*result)


# 수정한 후
import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

dp = [1] * N

for i in range(1, N) :
    for j in range(i) :
        if A[i] > A[j] :
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))

result = []
order =  max(dp)
for i in range(N - 1, -1, -1) :
        if dp[i] == order :
            result.append(A[i])
            order -= 1

result.reverse()
print(*result)
