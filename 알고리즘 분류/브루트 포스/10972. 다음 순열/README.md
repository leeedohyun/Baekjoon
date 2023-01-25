# 아이디어
---
<p>뒷자리 숫자부터 확인하여 바로 앞의 자리 수보다 크면 바꿔주는 역할을 수행한다. 바꾼 자리와 나머지 뒤의 숫자를 정렬한 리스트를 합쳐
결과를 출력한다.
1 4 3 2를 예로 들어보자.</p>
<p>i는 2부터 시작해서 앞의 숫자가 작은 값은 찾는다. 결국 i = 1인 위치에서 (1, 4)를 찾을 것이다. 
그리고 i - 1의 인덱스를 가진 1보다 작은 값을 다시 뒤에서부터 찾기 시작한다. j = 3에서 2를 찾으면 1과 2의 위치르 바꿔준다.
i의 앞에 있는 수와 정렬된 i부터 남은 수를 합쳐준다.</p>

시간이 조금 빠른 풀이

```python
import sys

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))

for i in range(N - 1, 0, -1) : 
  if numbers[i - 1] < numbers[i] :
    for j in range(N - 1, 0, -1) : 
      if numbers[i - 1] < numbers[j] :
        numbers[i - 1], numbers[j] = numbers[j], numbers[i - 1] 
        break
                
    numbers = numbers[:i] + sorted(numbers[i:])
                
    print(*numbers)
    exit()
    
print(-1)
```
