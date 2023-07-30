import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static Point from, to;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        from = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        to = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        
        bfs();
        
        System.out.println(min);
        
        br.close();
    }
    
    public static void bfs() {
        int[] dx = {-2, -2, 0, 0, 2, 2};
        int[] dy = {-1, 1, -2, 2, -1, 1};
        
        Queue<Point> queue = new LinkedList<>();
        
        queue.add(from);
        visited[from.x][from.y] = true;
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            
            if (now.x == to.x && now.y == to.y) {
                min = Math.min(min, now.count);
                return;
            }
            
            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx < 0 || nx >=n || ny < 0 || ny >= n)
                    continue;
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, now.count + 1));
                }
            }
        }
        min = - 1;
    }
    
    static class Point {
        int x;
        int y;
        int count;
        
        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}