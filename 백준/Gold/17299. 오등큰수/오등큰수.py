import sys
from collections import Counter

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().rstrip().split()))

stack = []
count = Counter(A)
NGF = [-1 for _ in range(N)]

stack.append(0)
for i in range(1, N):
    while stack and count[A[stack[-1]]] < count[A[i]]:
        NGF[stack.pop()] = A[i]
    stack.append(i)
        
print(*NGF)