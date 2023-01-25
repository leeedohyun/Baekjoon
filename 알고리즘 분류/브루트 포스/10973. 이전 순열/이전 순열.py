import sys

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))

for i in range(N - 1, 0, -1) : 
  if numbers[i - 1] > numbers[i] :
    for j in range(N - 1, 0, -1) : 
      if numbers[i - 1] > numbers[j] :
        numbers[i - 1], numbers[j] = numbers[j], numbers[i - 1] 
        break
                
    numbers = numbers[:i] + sorted(numbers[i:], reverse=True)
                
    print(*numbers)
    exit()
    
print(-1)
