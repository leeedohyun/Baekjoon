import sys
from itertools import combinations

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()

print('\n'.join(list(map(' '.join, combinations(map(str, arr), M)))))
