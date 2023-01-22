import sys

input = sys.stdin.readline

E, S, M = map(int, input().split())

year = 1
while E != 1 or S != 1 or M != 1 :
  E -= 1
  S -= 1
  M -= 1
  year += 1

  if E < 1 :
    E = 15
  if S < 1 :
    S = 28
  if M < 1 :
    M = 19
    
print(year)
