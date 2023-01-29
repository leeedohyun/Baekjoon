import sys
from itertools import permutations

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()

print('\n'.join(list(map(' '.join, permutations(map(str, arr), M)))))
