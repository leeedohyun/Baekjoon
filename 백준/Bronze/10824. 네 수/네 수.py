import sys

A, B, C, D = map(str, sys.stdin.readline().rstrip().split())

result1 = int(A + B)
result2 = int(C + D)

answer = result1 + result2

print(answer)