import math

N = int(input())

fac = math.factorial(N)

count = 0
for i in range(len(str(fac))):
    if fac % 10 == 0:
        count += 1
        fac //= 10

print(count)