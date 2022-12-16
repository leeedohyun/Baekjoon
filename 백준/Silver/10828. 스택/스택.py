import sys

def push(num):
    stack.append(num)

def pop():
    if empty() == 1:
        return -1
    else:
        return stack.pop()

def size():
     return len(stack)

def empty():
    if size() == 0:
        return 1
    else:
        return 0

def top():
    if empty() == 1:
        return -1
    else:
        return stack[-1]

N = int(input())
stack = []

for i in range(N):
    input_split = sys.stdin.readline().rstrip().split()
    command = input_split[0]

    if command == "push":
        push(input_split[1])
    elif command == "pop":
        print(pop())
    elif command == "size":
        print(size())
    elif command == "empty":
        print(empty())
    else:
        print(top())