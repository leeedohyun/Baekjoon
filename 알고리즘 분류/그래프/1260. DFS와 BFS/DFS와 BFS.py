import sys
from collections import deque
sys.setrecursionlimit(10 ** 6)

input = sys.stdin.readline

def dfs(graph, start):
    visited[start] = True
    print(start, end=' ')
    for x in sorted(graph[start]):
        if not visited[x]:
            dfs(graph, x)

def bfs(graph, start):
    q = deque([start])
    check[start] = True
    while q:
        now = q.popleft()
        print(now, end=' ')
        for x in sorted(graph[now]):
            if not check[x]:
                q.append(x)
                check[x] = True

n, m, v = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [False] * (n + 1)
check = [False] * (n + 1)

dfs(graph, v)
print()
bfs(graph, v)
