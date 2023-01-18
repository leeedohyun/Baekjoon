# 아이디어
-----------
**+** 와 **-** 로만 이루어진 사칙연산을 진행하므로 최솟값이 나오려면 **-** 를 기준으로 **-** 가 나오기 전까지 모든 수를 더한 다음 빼기를 계산한다.

```python
s = input().split('-')
result = []
for i in s:
    result.append(sum(map(int, i.split('+'))))
print(result[0]-sum(result[1:]))
```
이렇게 조금 더 간결하게 풀이할 수 있다.
