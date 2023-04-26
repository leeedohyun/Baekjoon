import sys

input = sys.stdin.readline

S = set()
M = int(input())

for _ in range(M):
    operation = input().split()

    if len(operation) == 1:
        if operation[0] == "all":
            S = set([x for x in range(1, 21)])
        elif operation[0] == "empty":
            S = set()
    else: 
        instruction, number = operation[0], int(operation[1])
        
        if instruction == "add":
            S.add(number)
        elif instruction == "remove":
            S.discard(number)
        elif instruction == "check":
            if number in S:
                print(1)
            else:
                print(0)
        elif instruction == "toggle":
            if number in S:
                S.discard(number)
            else:
                S.add(number)
