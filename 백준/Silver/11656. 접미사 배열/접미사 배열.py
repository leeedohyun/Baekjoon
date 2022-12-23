# 내가 푼 풀이
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
  
# 더 간결한 풀이
S = input()

suffix = []
for i in range(len(S)) :
    suffix.append(S[i:])

suffix.sort()
for i in suffix :
    print(i)
