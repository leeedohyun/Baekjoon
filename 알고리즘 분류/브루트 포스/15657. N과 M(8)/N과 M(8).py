import sys
from itertools import combinations_with_replacement as cwr

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()

print('\n'.join(list(map(' '.join, cwr(map(str, arr), M)))))
