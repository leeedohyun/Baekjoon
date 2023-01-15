import sys

input = sys.stdin.readline

N = int(input())
time = []

for _ in range(N) :
    time.append(list(map(int, input().split())))

time.sort(key = lambda x: x[0])
time.sort(key = lambda x: x[1])

count = 1
end = time[0][1]

for i in range(1, N) :
    if time[i][0] >= end :
        count += 1
        end = time[i][1]

print(count)