import sys
from itertools import permutations

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

result = []

for p in permutations(arr, N) :
    ans = 0
    for j in range(N - 1) :
        ans += abs(p[j] - p[j + 1])
    result.append(ans)

print(max(result))
