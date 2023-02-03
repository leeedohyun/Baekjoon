import sys
from itertools import combinations

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(list(map(int, input().split())))

arr = set(combinations(arr, M))

for i in sorted(arr) :
  print(*i)
