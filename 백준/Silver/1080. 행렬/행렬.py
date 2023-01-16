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