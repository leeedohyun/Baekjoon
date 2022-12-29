N = int(input())

number = 2

while N != 1:
    if N % number == 0:
        N /= number
        print(number)
    else:
        number += 1
