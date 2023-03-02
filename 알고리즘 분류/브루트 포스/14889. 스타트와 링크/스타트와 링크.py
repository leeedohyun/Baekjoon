import sys
from itertools import combinations

input = sys.stdin.readline

n = int(input())
a = [i for i in range(n)]
s = [list(map(int, input().split())) for _ in range(n)]

result = 999999
mid = n // 2
for c in combinations(a, mid):
  data = []
  for i in range(n):
    if i not in c:
      data.append(i)
  start, link = 0, 0
  for i in combinations(c, 2):
    start += s[i[0]][i[1]] + s[i[1]][i[0]]
  for i in combinations(data, 2):
    link += s[i[0]][i[1]] + s[i[1]][i[0]]

  result = min(result, abs(start - link))

print(result)
