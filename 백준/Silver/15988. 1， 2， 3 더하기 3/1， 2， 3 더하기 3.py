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