# 수정하기 전 : 계속 2중 for문으로 계산하는 방법 밖에 생각하지 못했다. 그 결과 시간 초과와 메모리 초과 발생

from sys import stdin

input = stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

result = numbers[0]

for i in range(n) :
    dp = []
    dp.append(numbers[i])

    for j in range(i + 1, n) :
        dp.append(dp[j - i - 1] + numbers[j])
    result = max(result, max(dp))

print(result)

# 수정한 후 : 시간(92ms)
from sys import stdin

input = stdin.readline

for i in range(n - 1) :
    sum.append(max(sum[i] + numbers[i + 1], numbers[i + 1]))

print(max(sum))


# 시간 단축한 코드: for문 안의 max함수를 제거함으로써 시간 단축
from sys import stdin

input = stdin.readline

n = int(input())
numbers = list(map(int, input().split()))

sum = [numbers[0]]

for i in range(1, n) :
    if sum[i - 1] > 0 :
        sum.append(sum[i - 1] + numbers[i])
    else :
        sum.append(numbers[i])

print(max(sum))
