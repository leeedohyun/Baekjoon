import sys

N, K = map(int, sys.stdin.readline().rstrip().split())

"""
요세푸스 순열
1. k의 배수의 사람 제거
2. 마지막 제거된 사람 뒷 번호를 1부터 다시 번호 매기기
3. 1 반복
4. 마지막으로 남은 사람 제거
"""

josephus = []
person = [i for i in range(1, N + 1)]
number = 0

for i in range(N):
    number += (K-1)

    if number >= len(person):
        number %= len(person)

    josephus.append(str(person.pop(number)))

print("<", ", ".join(josephus)[:], ">", sep='')