import sys
from itertools import product

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(set(map(int, input().split())))

arr.sort()

print('\n'.join(map(' '.join, product(map(str, arr), repeat=M))))
