import java.io.*;
import java.util.*;

public class Main {
    public static int n, l, r;
    public static int[][] A;
    public static boolean[][] visited;
    public static List<Location> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        A = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        
        }
        
        System.out.println(move());
        
        br.close();
    }
    
    public static int move() {
        int result = 0;
        while (true) {
            visited = new boolean[n][n];
            boolean isMove = false;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                    
                        if (list.size() > 1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }
            
            if (!isMove)
                return result;
            result++;
        }
    }
    
    public static int bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<Location> queue = new LinkedList<>();
        list = new ArrayList<>();
        
        queue.add(new Location(x, y));
        list.add(new Location(x,y));
        
        visited[x][y] = true;
        int sum = A[x][y];
        
        while (!queue.isEmpty()) {
            Location now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                    
                if (Math.abs(A[now.x][now.y] - A[nx][ny]) < l || Math.abs(A[now.x][now.y] - A[nx][ny]) > r)
                    continue;
                    
                if (!visited[nx][ny]) {
                    list.add(new Location(nx, ny));
                    queue.add(new Location(nx, ny));
                    visited[nx][ny] = true;
                    sum += A[nx][ny];
                }
            }
        }
        return sum;
    }
    
    private static void changePopulation(int sum) {
        int avg = sum / list.size();
        
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            
            A[x][y] = avg;
        }
    }
    
    public static class Location {
        int x;
        int y;
        
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}