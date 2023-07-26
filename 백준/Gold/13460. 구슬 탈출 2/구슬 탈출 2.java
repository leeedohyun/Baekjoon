import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static Ball redBall, blueBall;
    public static char[][] board;
    public static boolean[][][][] visited;
    public static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m][n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'R') {
                    redBall = new Ball(i, j, 0);
                }
                if (board[i][j] == 'B') {
                    blueBall = new Ball(i, j, 0);
                }
            }
        }

        bfs(redBall, blueBall);

        System.out.println(result);
    }

    public static void bfs(Ball red, Ball blue) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<Ball> redQueue = new LinkedList<>();
        Queue<Ball> blueQueue = new LinkedList<>();

        redQueue.offer(red);
        blueQueue.offer(blue);

        visited[red.x][red.y][blue.x][blue.y] = true;

        while(!redQueue.isEmpty() && !blueQueue.isEmpty()) {
            Ball nextRed = redQueue.poll();
            Ball nextBlue = blueQueue.poll();

            if (nextRed.count > 10) {
                result = -1;
                return;
            }

            if (board[nextBlue.x][nextBlue.y] == 'O')
                continue;

            if (board[nextRed.x][nextRed.y] == 'O') {
                result = nextRed.count;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int bx = nextBlue.x;
                int by = nextBlue.y;

                while (true) {
                    bx += dx[i];
                    by += dy[i];

                    if (board[bx][by] == 'O')
                        break;

                    if (board[bx][by] == '#') {
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }
                }

                int rx = nextRed.x;
                int ry = nextRed.y;

                while (true) {
                    rx += dx[i];
                    ry += dy[i];

                    if (board[rx][ry] == 'O')
                        break;

                    if (board[rx][ry] == '#') {
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }
                }

                if (bx == rx && by == ry && board[rx][ry] != 'O') {
                    int redDistance = Math.abs(nextRed.x - rx) + Math.abs(nextRed.y - ry);
                    int blueDistance = Math.abs(nextBlue.x - bx) + Math.abs(nextBlue.y - by);

                    if (redDistance > blueDistance) {
                        rx -= dx[i];
                        ry -= dy[i];
                    } else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                if (!visited[rx][ry][bx][by]) {
                    visited[rx][ry][bx][by] = true;
                    redQueue.offer(new Ball(rx, ry, nextRed.count + 1));
                    blueQueue.offer(new Ball(bx, by, nextBlue.count + 1));
                }
            }
        }
    }

    static class Ball {
        int x;
        int y;
        int count;

        public Ball(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}