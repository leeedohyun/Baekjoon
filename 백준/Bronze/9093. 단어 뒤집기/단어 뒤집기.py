import sys

N = int(input())

for i in range(N):
    word_list = list(map(str, sys.stdin.readline().rstrip().split()))

    for word in word_list:
        word_reversed = word[::-1]
        print(word_reversed, end=' ')
    print()