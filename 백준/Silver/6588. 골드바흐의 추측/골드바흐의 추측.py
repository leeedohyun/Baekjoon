# 시간 초과 : number를 입력할 때마다 소수를 구해줌
import math
from sys import stdin

while True:
    number = int(stdin.readline())

    if number == 0:
        break

    flag = [True for _ in range(1000000)]
            
    for i in range(2, int(math.sqrt(1000000)) + 1):
        if flag[i]:
            for j in range(i + i, 1000000, i):
                flag[j] = False
            
    check = False
    for i in range(3, number):
        if flag[i] and flag[number - i]:
                print("%d = %d + %d" % (number, i, number - i))
                check = True
                break

    if not check:
        print("Goldbach's conjecture is wrong.")

# 입력할 수 있는 number의 범위 내의 소수를 한 번만 구하기
import math
from sys import stdin

flag = [True for _ in range(1000000)]
            
for i in range(2, int(math.sqrt(1000000)) + 1):
    if flag[i]:
        for j in range(i + i, 1000000, i):
            flag[j] = False

while True:
    number = int(stdin.readline())

    if number == 0:
        break
    
    check = False
    for i in range(3, number):
        if flag[i] and flag[number - i]:
                print("%d = %d + %d" % (number, i, number - i))
                check = True
                break

    if not check:
        print("Goldbach's conjecture is wrong.")
