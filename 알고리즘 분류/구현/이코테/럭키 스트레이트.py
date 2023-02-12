N = input()

left_sum = 0
right_sum = 0

index = len(N) // 2

for i in range(len(N)) :
  if i < index :
    left_sum += int(N[i])
  else :
    right_sum += int(N[i])

if left_sum == right_sum :
  print("LUCKY")
else :
  print("READY")
