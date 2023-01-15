```
풀이 아이디어
회의의 최대 갯수를 구하려면 시간으로 정렬하여 앞의 끝나는 시간이 다음 시작될 회의의 시간보다 작으면 된다.
하지만 여기서 추가적으로 생각해줘야 할 부분은 끝나는 시간이 같은 경우이다.
예를 들어 (1,3)과 (3,3)인 경우이다. 끝나는 시간이 같지만 시작 시간도 같아 저런 경우도 세어주어야 한다.
```
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
  
print(time)
