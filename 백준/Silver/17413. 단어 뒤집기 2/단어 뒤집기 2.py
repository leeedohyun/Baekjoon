word = input()

tmp = []
result = []

for i in range(len(word)):
    if word[i] == '<' and tmp:
        tmp.reverse()
        result.append(''.join(tmp))
        tmp = [word[i]]
    elif word[i] == '>':
        tmp.append(word[i])
        result.append(''.join(tmp))
        tmp = []
    elif word[i] == ' ' and '<' not in tmp:
        tmp.reverse()
        result.append(''.join(tmp))
        result.append(word[i])
        tmp = []
    else:
        tmp.append(word[i])

if tmp:
    tmp.reverse()
    result.append(''.join(tmp))

print(''.join(result))