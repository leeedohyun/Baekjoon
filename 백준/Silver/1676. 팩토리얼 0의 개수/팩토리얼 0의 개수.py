# 내가 푼 풀이
import math

N = int(input())

fac = math.factorial(N)

count = 0
for i in range(len(str(fac))):
    if fac % 10 == 0:
        count += 1
        fac //= 10

print(count)

# 소인수 분해를 이용한 풀이: 0이 늘어나는 경우는 5의 개수가 늘어날 때
N = int(input())

count = 0

while N >= 5:
    count += N//5
    N //= 5
    
print(count)
