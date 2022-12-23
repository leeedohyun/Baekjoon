import sys

while True:
    S = sys.stdin.readline().rstrip('\n')

    if not S:
        break

    lower_case, upper_case, number, space = 0, 0, 0, 0
    
    for i in S:
        if i.islower():
            lower_case += 1
        elif i.isupper():
            upper_case += 1
        elif i.isdigit():
            number += 1
        elif i.isspace():
            space += 1
        
    print(lower_case, upper_case, number, space)