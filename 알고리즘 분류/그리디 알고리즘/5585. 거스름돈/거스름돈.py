change = 1000 - int(input())
coins = [500, 100, 50 , 10, 5, 1]

result = 0
for coin in coins :
    result += (change // coin)
    change %= coin

print(result)
