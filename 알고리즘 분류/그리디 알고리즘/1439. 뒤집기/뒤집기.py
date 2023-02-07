S = input()

zero = 0
one = 0

if S[0] == '0' :
    zero += 1
else :
    one += 1
    
for i in range(len(S) - 1) :
    if S[i] != S[i + 1] :
        if S[i + 1] == '0' :
            zero += 1
        else :
            one += 1

print(min(zero, one))
