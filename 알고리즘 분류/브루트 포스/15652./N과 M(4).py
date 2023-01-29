def dfs() :
  if len(s) == M :
    print(' '.join(map(str, s)))
    return

  for i in range(1, N + 1) :
    if len(s) == 0 :
      s.append(i)
      dfs()
      s.pop()
    else :
      if s[-1] <= i :
        s.append(i)
        dfs()
        s.pop()
        

import sys

input = sys.stdin.readline

N, M = map(int, input().split())
s = []
visited = [False] * (N + 1)

dfs()
