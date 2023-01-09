import sys

input = sys.stdin.readline().rstrip

words = input()

stack = []
result = ''

for word in words :
    if word.isalpha() :
        result += word
        
    if word == '(' :
        stack.append(word)
    elif word == '*' or word == '/' :
        while stack and (stack[-1] == '*' or stack[-1] == '/') :
            result += stack.pop()
        stack.append(word)
    elif word == '+' or word == '-' :
        while stack and stack[-1] != '(' :
            result += stack.pop()
        stack.append(word)
    elif word == ')' :
        while stack and stack[-1] != '(' :
            result += stack.pop()
        stack.pop()

while stack :
    result += stack.pop()

print(result)