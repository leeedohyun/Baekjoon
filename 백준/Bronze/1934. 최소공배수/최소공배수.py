import sys
import math

T = int(input())

for i in range(T):
    num1, num2 = map(int, sys.stdin.readline().split())
    print(math.lcm(num1, num2))