import sys
from itertools import combinations

input = sys.stdin.readline

dwalfs = []

for _ in range(9) :
  dwalfs.append(int(input()))

for seven in combinations(dwalfs, 7) :
  if sum(seven) == 100 :
    for dwalf in seven :
      print(dwalf)
