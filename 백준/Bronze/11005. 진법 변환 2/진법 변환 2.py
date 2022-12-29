from sys import stdin
import string

tmp = string.digits + string.ascii_uppercase

N, B = map(int, stdin.readline().split())

result = ""
while N != 0:
    result += tmp[N % B]
    N //= B

print(result[::-1])