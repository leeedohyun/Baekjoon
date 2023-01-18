import sys

input = sys.stdin.readline().strip

numbers = input().split('-')
result = 0

for i in numbers[0].split('+') :
  result += int(i)

for i in numbers[1:] :
  for j in i.split('+') :
    result -= int(j)
  
print(result)
