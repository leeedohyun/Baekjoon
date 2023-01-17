def check(arr, i) :
  if arr[i - 1] != B[i - 1] :
    return False
  return True
  
import sys

input = sys.stdin.readline

N = int(input())

A = list(map(int, input().strip()))
B = list(map(int, input().strip()))

countChoose = 1
countPass = 0

chooseFirst = A[:]
for i in range(0, 2) :
  chooseFirst[i] = 1 - chooseFirst[i]
  
passFirst = A[:]

for i in range(1, N) :
    if i != N - 1 and not check(chooseFirst, i) :
        for j in range(i - 1, i + 2) :
            chooseFirst[j] = 1 - chooseFirst[j]
        countChoose += 1
    elif i == N - 1 and not check(chooseFirst, i) :
        for j in range(i - 1, N) :
            chooseFirst[j] = 1 - chooseFirst[j]
        countChoose += 1
  
    if i != N - 1 and not check(passFirst, i) :
        for j in range(i - 1, i + 2) :
            passFirst[j] = 1 - passFirst[j]
        countPass += 1
    elif i == N - 1 and not check(passFirst, i) :
        for j in range(i - 1, N) :
            passFirst[j] = 1 - passFirst[j]
        countPass += 1
  
if chooseFirst == B and passFirst == B :
    print(min(countChoose, countPass))
elif chooseFirst == B and passFirst != B :
    print(countChoose)
elif chooseFirst != B and passFirst == B :
    print(countPass)
else :
    print(-1)
