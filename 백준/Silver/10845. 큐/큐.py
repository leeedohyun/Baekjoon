import sys

N = int(input())

que = []
for i in range(N):
    command = sys.stdin.readline().rstrip().split()

    if command[0] == "push":
        que.append(command[1])
    elif command[0] == "pop":
        if len(que) == 0:
            print(-1)
        else:
            print(que.pop(0))
    elif command[0] == "size":
        print(len(que))
    elif command[0] == "empty":
        if len(que) == 0:
            print(1)
        else:
            print(0)
    elif command[0] == "front":
        if len(que) == 0:
            print(-1)
        else:
            print(que[0])
    elif command[0] == "back":
        if len(que) == 0:
            print(-1)
        else:
            print(que[-1])