S = input()

stick = []
count = 0

for i in range(len(S)):
    if S[i] == '(' and S[i + 1] != ')':
        stick.append(S[i])
    elif S[i] == ')' and S[i - 1] != '(':
        stick.pop()
        count += 1
    elif S[i] == ')' and S[i - 1] == '(':
        count += len(stick)

print(count)