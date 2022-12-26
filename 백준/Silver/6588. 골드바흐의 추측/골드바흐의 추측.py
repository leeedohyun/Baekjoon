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