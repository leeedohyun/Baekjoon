import sys

N = int(sys.stdin.readline().rstrip())
A = list(map(int, sys.stdin.readline().rstrip().split()))

stack = []
NCE = [-1 for _ in range(N)]

stack.append(0)
for i in range(1, N):
    while stack and A[stack[-1]] < A[i]:
        NCE[stack.pop()] = A[i]
    stack.append(i)

print(*NCE)