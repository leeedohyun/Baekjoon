# 처음 작성한 코드 sum_count는 점화식으로 인해 한 번만 계산해주면 되는데 n을 입력할 때마다 구하도록 구현하여 메모리 초과
from sys import stdin

T = int(stdin.readline())

for i in range(T) :
    n = int(stdin.readline())

    sum_count = [0 for _ in range(1000001)]
    sum_count[1] = 1
    sum_count[2] = 2
    sum_count[3] = 4

    for i in range(4, n + 1) :
        sum_count[i] = sum_count[i - 1] + sum_count[i - 2] + sum_count[i - 3]
    
    print(sum_count[n] % 1000000009)

# 안의 for문을 분리하여 다이나믹 프로그래밍을 이용하여 sum_count를 먼저 구해 놓기
from sys import stdin

T = int(stdin.readline())

sum_count = [0 for _ in range(1000001)]
sum_count[1] = 1
sum_count[2] = 2
sum_count[3] = 4

for i in range(4, 1000001) :
    sum_count[i] = (sum_count[i - 1] + sum_count[i - 2] + sum_count[i - 3]) % 1000000009

for i in range(T) :
    n = int(stdin.readline())

    print(sum_count[n])
