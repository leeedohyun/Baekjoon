# 아이디어
---------------
기본적으로 이전의 전구의 상태가 다르다면 현재 위치에서 스위치를 눌러야 한다. 
하지만 첫번째 전구같은 경우는 이전의 전구가 없기 때문에 첫번째 전구를 누른 경우와 누르지 않은 경우로 나누어서 풀이했다.

check함수를 통해서 이전의 값이랑 같은지 확인을 해주고 현재 위치가 마지막이 아니면 현재 위치를 포함하여 이전과 다음 전구의 상태를 바꾸고 
현재 위치가 마지막이라면 이전과 현재 위치의 전구만 바꾸도록 for문을 만들었다.

마지막으로 결과는 첫번째 전구를 선택한 경우와 아닌 경우 두 리스트를 B와 비교하여 결과를 출력한다.
```python
import sys

input = sys.stdin.readline

n = int(input())
a, b = list(input().rstrip()), list(input().rstrip())

def count(start_idx):
    data = [int(a[i] != b[i]) for i in range(n)]
    res = 0
    for i in range(start_idx, n):
        if not i or data[i - 1]:
            data[i] = 1 - data[i]
            if i - 1 >= 0: data[i - 1] = 1 - data[i - 1]
            if i + 1 < n: data[i + 1] = 1 - data[i + 1]
            res += 1
    if sum(data):
        res = -1
    return res
z, o = count(0), count(1)
if z == -1 and o == -1:
    print(-1)
elif o != -1:
    print(o)
elif z != -1:
    print(z)
else:
    print(min(o, z))
```
내가 푼 풀이보다 더 간결하게 푼 풀이이다.
