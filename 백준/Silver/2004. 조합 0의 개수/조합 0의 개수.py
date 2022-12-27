def count_two(num):
    count = 0

    while num:
        count += num // 2
        num //= 2

    return count

def count_five(num):
    count = 0

    while num:
        count += num // 5
        num //= 5

    return count

n, m = map(int, input().split())

two_count = count_two(n) - count_two(m) - count_two(n - m)
five_count = count_five(n) - count_five(m) - count_five(n - m)

print(min(two_count, five_count))