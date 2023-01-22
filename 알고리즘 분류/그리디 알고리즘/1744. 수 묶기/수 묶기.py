import sys

input = sys.stdin.readline

N = int(input())

positive = []
negative = []
result = 0

for i in range(N) :
  number = int(input())

  if number > 1 :
    positive.append(number)
  elif number <= 0 :
    negative.append(number)
  else :
    result += number

positive.sort(reverse=True)
negative.sort()

for i in range(0, len(positive), 2) :
  if i + 1 >= len(positive) :
    result += positive[i]
  else :
    result += (positive[i] * positive[i + 1])

for i in range(0, len(negative), 2) :
  if i + 1 >= len(negative) :
    result += negative[i]
  else :
    result += (negative[i] * negative[i + 1])

print(result)
