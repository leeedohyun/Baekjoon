import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int min = 100;
    public static boolean[] visited = new boolean[100];
    public static int[][] board, ladder, snake;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[10][10];
        ladder = new int[n][2];
        snake = new int [m][2];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = (10 * i) + j + 1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ladder[i][0] = Integer.parseInt(st.nextToken());
            ladder[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            snake[i][0] = Integer.parseInt(st.nextToken());
            snake[i][1] = Integer.parseInt(st.nextToken());
        }
        
        bfs(board[0][0], 0);
        
        System.out.println(min);
        
        br.close();
    }
    
    public static void bfs(int start, int count) {
        Queue<Point> queue = new LinkedList<>();
        
        queue.add(new Point(start, count));
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
     
            if (now.data == 100) {
                min = Math.min(min, now.count);
                return;
            }
            
            for (int i = 1; i <= 6; i++) {
                int next = now.data + i;
                
                if (next > 100)
                    continue;
                
                for (int j = 0; j < m; j++) {
                    if (next == snake[j][0]) {
                        visited[next - 1] = true;
                        queue.add(new Point(snake[j][1], now.count + 1));
                        break;
                    }
                }
                
                for (int j = 0; j < n; j++) {
                    if (next == ladder[j][0]) {
                        visited[ladder[j][1] - 1] = true;
                        queue.add(new Point(ladder[j][1], now.count + 1));
                        break;
                    }
                }
                if (!visited[next - 1]) {
                    visited[next - 1] = true;
                    queue.add(new Point(next, now.count + 1));
                }
            }
        }
    }
    
    static class Point {
        int data;
        int count;
        
        public Point(int data, int count) {
            this.data = data;
            this.count = count;
        }
    }
}