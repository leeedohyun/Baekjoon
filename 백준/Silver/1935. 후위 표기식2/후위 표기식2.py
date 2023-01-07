from sys import stdin

input = stdin.readline

N = int(input())
words = input().rstrip()
numbers = [0] * N

for i in range(N) :
    numbers[i] = int(input())

stack = []

for word in words :
    if word.isalpha():
        stack.append(numbers[ord(word) - ord('A')])
    else :
        number2 = stack.pop()
        number1 = stack.pop()

        if word == '+' :
            stack.append(number1 + number2)
        elif word == '-' :
            stack.append(number1 - number2)
        elif word == '*' :
            stack.append(number1 * number2)
        elif word == '/' :
            stack.append(number1 / number2)
    
print('%.2f' % stack[-1])            