import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
A_revesed = A[::-1]

increase = [1] * N
decrease = [1] * N

for i in range(1, N) :
    for j in range(i) :
        if A[i] > A[j] :
            increase[i] = max(increase[i], increase[j] + 1)
    
        if A_revesed[i] > A_revesed[j] :
            decrease[i] = max(decrease[i], decrease[j] + 1)

print(max([x + y - 1 for x, y in zip(increase, decrease[::-1])]))