N = int(input())

result = [[0 for _ in range(10)] for _ in range(101)]
result[1] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]

for i in range(2, N + 1) :
    result[i][0] = result[i - 1][1]
    result[i][9] = result[i - 1][8]
    
    for j in range(1, 9) :
        result[i][j] = result[i - 1][j - 1] + result[i - 1][j + 1]

print(sum(result[N]) % 1000000000)