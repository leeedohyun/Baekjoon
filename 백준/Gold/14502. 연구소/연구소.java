import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int max = Integer.MIN_VALUE;
    public static int[][] laboratory;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        laboratory = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                laboratory[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        selectThreePoint(0);
        
        System.out.println(max);
        
        br.close();
    }
    
    public static void bfs() {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        Queue<Point> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (laboratory[i][j] == 2)
                    queue.add(new Point(i, j));
            }
        }
        
        int[][] copy = new int[n][m];
        
        for (int i = 0; i < n; i ++) {
            copy[i] = laboratory[i].clone();
        }
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                
                if (copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        findMax(copy);
    }
    
    private static void selectThreePoint(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (laboratory[i][j] == 0) {
                    laboratory[i][j] = 1;
                    selectThreePoint(depth + 1);
                    laboratory[i][j] = 0;
                }
            }
        }
    }
    
    private static void findMax(int[][] copy) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0)
                    count++;
            }
        }
        max = Math.max(max, count);
    }
    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}