import math
import sys

N, S = map(int, input().split())
A = list(map(int, sys.stdin.readline().rstrip().split()))

distances = []
for i in A:
    distances.append(abs(S - i))

D = distances[0]
for distance in distances[1:]:
    D = math.gcd(distance, D)

print(D)