import sys
import math

num1, num2 = map(int, sys.stdin.readline().rstrip().split())

print(math.gcd(num1, num2))
print(math.lcm(num1, num2))

# 유클리드 호제법 : 두 수가 상대방의 수로 나누어 원하는 수를 얻는 알고리즘
def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

def lcm(a, b):
    return a * b / gcd(a, b)
