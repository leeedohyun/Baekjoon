import sys

stack1 = list(sys.stdin.readline().strip())
stack2 = []
M = int(sys.stdin.readline().strip())


for i in range(M):
    command = sys.stdin.readline().strip().split()

    if command[0] == "L" and stack1:
        stack2.append(stack1.pop())
    elif command[0] == "D" and stack2:
        stack1.append(stack2.pop())
    elif command[0] == "B" and stack1:
        stack1.pop()
    elif command[0] == "P":
        stack1.append(command[1])

result = ''.join(stack1 + list(reversed(stack2)))
print(result)