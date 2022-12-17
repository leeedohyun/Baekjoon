T = int(input())

for i in range(T):
    s = input()
    isVPS = True
    stack = []

    for j in s:
        if j == '(':
            stack.append(j)
        elif j == ')':
            if stack:
                stack.pop()
            elif not stack:
                isVPS = False
                break

    if not stack and isVPS:
        print("YES")
    elif stack or not isVPS:
        print("NO")