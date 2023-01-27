# 아이디어
----------
1부터 N까지의 수 중에서 M개를 뽑는 문제이다. 이 문제는 itertools로 풀 수 있지만 다양한 방식으로 구현할 수 있다.
먼저 재귀함수를 사용해서 구현해보자.

```python
def perm(arr, n) :
  result = []

  if n > len(arr) :
    return result
  
  if n == 1 :
    for i in arr :
      result.append([i])
  elif n > 1 :
    for i in range(len(arr)) :
      ans = [i for i in arr]
      ans.remove(arr[i])
      
      for p in perm(ans, n - 1) :
        result.append([arr[i]] + p)
  
  return result
  
```

이제 dfs를 이용하여 구현해보자.

```python
def dfs_iteration(graph, root):
    visited = []
    stack = [root]
    
    while(stack): 
        node = stack.pop() 
   
        if(node not in visited):
            visited.append(node)
            stack.extend(graph[node])
            
    return visited
```
