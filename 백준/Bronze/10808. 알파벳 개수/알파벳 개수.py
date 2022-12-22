S = input()

alphabet = [0 for _ in range(26)]

for i in S:
    alphabet[ord(i) - ord('a')] += 1

print(*alphabet)