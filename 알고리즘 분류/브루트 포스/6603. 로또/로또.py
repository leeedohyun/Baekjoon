import sys
from itertools import combinations

input = sys.stdin.readline

while True:
    data = list(map(int, input().split()))

    k = data[0]
    s = data[1:]

    for comb in combinations(s, 6):
        print(*comb)
    print()

    if k == 0:
        exit()
