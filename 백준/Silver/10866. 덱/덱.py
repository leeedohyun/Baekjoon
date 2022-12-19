import sys
from collections import deque

N = int(input())

deq = deque()
for i in range(N):
    command = sys.stdin.readline().rstrip().split()

    if command[0] == "push_front":
        deq.appendleft(command[1])
    elif command[0] == "push_back":
        deq.append(command[1])
    elif command[0] == "pop_front":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq.popleft())
    elif command[0] == "pop_back":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq.pop())
    elif command[0] == "size":
        print(len(deq))
    elif command[0] == "empty":
        if len(deq) == 0:
            print(1)
        else:
            print(0)
    elif command[0] == "front":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq[0])
    elif command[0] == "back":
        if len(deq) == 0:
            print(-1)
        else:
            print(deq[-1])