from collections import deque

S = input()

deq = deque(S)

result = []

for i in range(len(S)):
    result.append(''.join(list(deq)))
    deq.popleft()

result.sort()

for i in result:
    print(i)