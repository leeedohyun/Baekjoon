import sys
import itertools

input = sys.stdin.readline

dwalf = [int(input()) for _ in range(9)]

for i in itertools.combinations(dwalf, 7) :
  if sum(i) == 100 :
    for j in sorted(i) :
      print(j)
    break
