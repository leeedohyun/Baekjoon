# 아이디어
-------------
s의 길이가 0인 경우에는 s의 마지막 원소와 i의 크기를 비교할 수 없으므로 경우를 나누어 계산한다.
이렇게 풀어도 시간이 오래 걸리지는 않지만 이 문제를 조금 더 생각해보면 중복 조합 문제라는 것을 알 수 있다.
중복 조합으로 문제를 풀면 다음과 같이 풀이할 수 있다.

```python
import sys
from itertools import combinations_with_replacement as cwr

input = sys.stdin.readline

N, M = map(int, input().split())

L = [(i+1) for i in range(N)]
print('\n'.join(list(map(' '.join, cwr(map(str, L), M)))))
```
