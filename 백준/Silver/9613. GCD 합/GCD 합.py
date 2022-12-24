import sys
import math

T = int(input())

for i in range(T):
    numbers = list(map(int, sys.stdin.readline().rstrip().split()))

    sum = 0

    for j in range(1, len(numbers)):
        for k in range(j + 1, len(numbers)):
            sum += math.gcd(numbers[j], numbers[k])

    print(sum)