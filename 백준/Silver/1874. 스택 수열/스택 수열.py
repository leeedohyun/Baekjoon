n = int(input())
stack = []
list = []
count = 1
flag = True

for i in range(n):
    number = int(input())

    while count <= number:
        stack.append(count)
        list.append("+")
        count += 1

    if stack[-1] == number:
        stack.pop()
        list.append("-")
    else:
        flag = False

if flag == False:
    print("NO")
else:
    for i in list:
        print(i)