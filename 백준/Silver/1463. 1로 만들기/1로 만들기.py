'''
처음 푼 풀이 : 입력 받는 X에서 1을 빼면 2또는 3으로 나누어 떨어진다는 사실을 생각하지 못하고
            1을 빼는 과정을 while문으로 반복하여 시간초과 발생
'''
X = int(input())

result = [0 for _ in range(1000001)]
result[2] = 1

for i in range(3, X + 1) :
    n = i

    while n != 1 :
        a = n // 2
        b = n // 3
        if n % 3 == 0 and (result[b] < result[a] or b == 1) :
            result[i] += result[b] + 1
            break
        elif n % 2 == 0 and result[a] < result[b] :
            result[i] += result[a] + 1
            break
        else :
            result[i] += 1
            n -= 1
    
print(result[X])

# 수정한 풀이
X = int(input())

result = [0 for _ in range(X + 1)]

for i in range(2, X + 1) :
    result[i] = result[i - 1] + 1

    if i % 2 == 0 :
        result[i] = min(result[i], result[i // 2] + 1)
    if i % 3 == 0 :
        result[i] = min(result[i], result[i // 3] + 1)
    
print(result[X])
