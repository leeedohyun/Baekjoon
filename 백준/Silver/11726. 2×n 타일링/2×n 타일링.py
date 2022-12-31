n = int(input())

result = [0 for _ in range(1001)]
result[1] = 1
result[2] = 2

for i in range(3, 1001) :
    result[i] = result[i - 2] + result[i - 1]

print(result[n] % 10007)