import sys
import heapq

input = sys.stdin.readline

n = int(input())

pd = [list(map(int, input().split())) for _ in range(n)]
pd.sort(key=lambda x: x[1])

a = []
for pay, day in pd :
  heapq.heappush(a, pay)
  if len(a) > day :
    heapq.heappop(a)

print(sum(a))
