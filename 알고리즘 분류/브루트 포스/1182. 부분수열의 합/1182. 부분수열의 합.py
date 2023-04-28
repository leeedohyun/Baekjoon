from itertools import combinations

N, S = map(int, input().split())
data = list(map(int, input().split()))

result = 0
for i in range(1, N + 1):
    list = combinations(data, i)
    
    for j in list:
        if sum(j) == S:
            result += 1

print(result)
