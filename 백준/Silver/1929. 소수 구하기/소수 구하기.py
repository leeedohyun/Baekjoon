# 시간 초과
M, N = map(int, input().split())

sosu = []
for i in range(M, N + 1):
    flag = True

    if i == 1:
        continue

    for j in range(2, i):
        if i % j == 0:
            flag = False
            break
    
    if flag == True:
        sosu.append(i)

for i in sosu:
    print(i)

'''
에라토스테네스의 체 : 소수를 판별하는 알고리즘    
시간 복잡도 : O(N)을 O(N^(1/2))로 바꿔줌
원리 : 2부터  시작해서 소수를 만나면 소수의 배수를 다 지우는 과정을 반복한다.
      n보다 작은 소수를 구할 때 n보다 큰 제곱근 중 가장 작은 수보다 작은 소수들의 배수를 지우고 남는 수는 모두 소수
예 : n = 120인 경우 11^2 > 120 이므로 11보다 작은 소수 2, 3, 5, 7의 배수들을 지우고 남는 수들은 모두 소수이다.
'''

M, N = map(int, input().split())

sosu = []
for i in range(M, N + 1):
    flag = True

    if i == 1:
        continue

    for j in range(2, int(i ** 0.5) + 1):
        if i % j == 0:
            flag = False
            break
    
    if flag == True:
        sosu.append(i)

for i in sosu:
    print(i)
