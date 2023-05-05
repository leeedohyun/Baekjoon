from collections import deque
import sys

input = sys.stdin.readline

dx = [-1, -2, -2, -1, 1, 2, 2, 1]
dy = [2, 1, -1, -2, -2, -1, 1, 2]

N = int(input())

def bfs() :
    q = deque()
    q.append((start_x, start_y))
    data[start_x][start_y] = 1

    while q :
        x, y = q.popleft()
        if x == end_x and y == end_y :
            return data[x][y] - 1
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < l and 0 <= ny < l and data[nx][ny] == 0:
                q.append((nx, ny))
                data[nx][ny] = data[x][y] + 1
                

for _ in range(N) :
    l = int(input())
    start_x, start_y = map(int, input().split())
    end_x, end_y = map(int, input().split())
    data = [[0] * l for _ in range(l)]
    print(bfs())
