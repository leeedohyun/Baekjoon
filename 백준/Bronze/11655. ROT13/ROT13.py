S = input()

for i in S:
    if i.islower():
        if ord('z') < ord(i) + 13:
            print(chr(ord('a') + ord(i) + 12 - ord('z')), end='')
        else:
            print(chr(ord(i) + 13), end='')
    elif i.isupper():
        if ord('Z') < ord(i) + 13:
            print(chr(ord('A') + ord(i) + 12 - ord('Z')), end='')
        else:
            print(chr(ord(i) + 13), end='')
    elif i.isspace() or i.isdigit():
        print(i, end='')