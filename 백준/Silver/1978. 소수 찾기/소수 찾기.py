import sys

N = int(input())

numbers = list(map(int, sys.stdin.readline().rstrip().split()))

count = 0
for number in numbers:
    flag = True

    if number == 1:
        continue

    for i in range(2, number):
        if number % i == 0:
            flag = False
    
    if flag == True:
        count += 1

print(count)
