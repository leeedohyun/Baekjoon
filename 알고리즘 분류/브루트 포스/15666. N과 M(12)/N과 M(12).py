import sys
from itertools import combinations_with_replacement as cwr

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(set(map(int, input().split())))

arr.sort()

print('\n'.join(map(' '.join, cwr(map(str, arr), M))))
