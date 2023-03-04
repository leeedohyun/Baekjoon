import sys
sys.setrecursionlimit(10 ** 6)

input = sys.stdin.readline

def dfs(now, depth):
    if depth == 4:
        print(1)
        exit()
    visited[now] = True
    for next in graph[now]:
        if not visited[next]:
            dfs(next, depth + 1)
            visited[next] = False

n, m = map(int, input().split())
graph = [[] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * n

for i in range(n):
    dfs(i, 0)
    visited[i] = False

print(0)
