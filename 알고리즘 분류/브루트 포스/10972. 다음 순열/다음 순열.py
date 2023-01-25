import sys

input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))

for i in range(N - 1, 0, -1) : 
  if numbers[i - 1] < numbers[i] :
        for j in range(N - 1, 0, -1) : 
          if numbers[i - 1] < numbers[j] :
                numbers[i - 1], numbers[j] = numbers[j], numbers[i - 1] 
                numbers = numbers[:i] + sorted(numbers[i:])
                for i in numbers :
                    print(i, end=' ')
                exit()
print(-1)
