# 아이디어
----------------
A와 B의 3x3의 행렬의 원소만 뒤집기 위해 이보다 작은 부분 행렬은 뒤집을 수 없다. 그래서 A의 현재 위치에 해당하는 원소와 같은 위치에 존재하는 B의 원소를 비교하여 같으면 뒤집지 않고 다르면 뒤집는다.

```python
def convert(i, j) :
  for x in range(i, i + 3) :
    for y in range(j, j + 3) :
      A[x][y] = 1 - A[x][y]

def check() :
  for i in range(N) : 
    for j in range(M) :
      if A[i][j] != B[i][j] :
        return False
  return True
  
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

A = [list(map(int, input().strip())) for _ in range(N)]
B = [list(map(int, input().strip())) for _ in range(N)]

count = 0

for i in range(N - 2) : 
  for j in range(M - 2) :
    if A[i][j] != B[i][j] :
      count += 1
      convert(i, j)

if check() :
  print(count)
else :
  print(-1)
```

나는 이렇게 풀었지만 check()를 해야할 필요없이 행렬 A와 행렬 B가 같은지 확인하면 된다.
