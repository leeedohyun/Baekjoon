from sys import stdin
import math

flag = [False, False] + [True for _ in range(2, 1000001)]

for i in range(2, int(math.sqrt(1000001)) + 1):
    if flag[i]:
        for j in range(i + i, 1000001, i):
            flag[j] = False

T = int(stdin.readline())

for i in range(T):
    N = int(stdin.readline())
    
    if N == 0:
        break

    count = 0
    for i in range(N // 2 + 1):
        if flag[i] and flag[N - i]:
            count += 1
    
    print(count)