'''
일반적으로 이진법 구하는 방법으로 풀이 (나머지는 0 or 양수)
-13 = (-2) * 7 + 1
7 = (-2) * (-3) + 1
-3 = (-2) * (2) + 1
2 = (-2) * (-1) + 0
-1 = (-2) * 1 + 1

-2로 떨어지지 않는 경우 : -13 / -2 = 6으로 나오기 때문에 +1
'''
N = int(input())

result = ''

if not N:
    print(0)
    exit()

while N:
    if N % -2:
        N = N // -2 + 1
        result = '1' + result
    else:
        N //= -2
        result = '0' + result

print(result)