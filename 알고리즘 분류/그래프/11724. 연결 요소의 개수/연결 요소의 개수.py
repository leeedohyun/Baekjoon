# dfs
import sys

input = sys.stdin.readline

def dfs(now, depth):
  visited[now] = True
  for next in graph[now]:
    if not visited[next]:
      dfs(next, depth + 1)
  

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
  u, v = map(int, input().split())
  graph[u].append(v)

visited = [False] * (n + 1)
count = 0

for i in range(1, n + 1):
  if not visited[i]:
    if not graph[i]:
      count += 1
      visited[i] = True
    else:
      dfs(i, 0)
      count += 1

print(count)

#bfs
def bfs(start):
  queue = deque([start])
  visited[start] = True
  while queue:
    node = queue.popleft()
    for i in graph[node]:
      if not visited[i]:
        visited[i] = True
        queue.append(i)
