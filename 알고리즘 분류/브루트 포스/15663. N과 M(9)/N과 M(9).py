import sys
from itertools import permutations

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(set(permutations(list(map(int, input().split())), M)))

for i in arr :
    print(*i)
