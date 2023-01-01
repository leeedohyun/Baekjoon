from sys import stdin

T  = int(stdin.readline())

result = [0 for _ in range(12)]
result[1] = 1
result[2] = 2
result[3] = 4

for j in range(4, 12) :
    result[j] = result[j - 1] + result[j - 2] + result[j - 3]

for i in range(T) :
    n = int(stdin.readline())
    
    print(result[n])