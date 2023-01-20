import sys

input = sys.stdin.readline().rstrip

N = input()
N = sorted(N, reverse=True)

sum = 0
for i in N :
  sum += int(i)

if '0' not in N or sum % 3 != 0:
  print(-1)
else :
  print(''.join(N))
