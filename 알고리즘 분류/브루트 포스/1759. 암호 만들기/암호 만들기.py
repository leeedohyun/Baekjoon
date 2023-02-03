import sys
from itertools import combinations

input = sys.stdin.readline

L, C = map(int, input().split())
arr = sorted(list(map(str, input().split())))

for i in combinations(arr, L) :
  cons_count = 0
  vow_count = 0
  for j in i :
    if j in ['a', 'e', 'i', 'o', 'u'] :
      cons_count += 1
    else : 
      vow_count += 1

  if cons_count >= 1 and vow_count >= 2 :
    print(''.join(i))
