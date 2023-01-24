import sys

input = sys.stdin.readline

buttons = [i for i in range(10)]
N = int(input())
M = int(input())
broken = list(map(int, input().split()))

min_count = abs(100 - N)

for nums in range(1000001) :
  nums = str(nums)

  for j in range(len(nums)) :
    if int(nums[j]) in broken :
      break
    elif j == len(nums) - 1 :
      min_count = min(min_count, abs(int(nums) - N) + len(nums))

print(min_count)
