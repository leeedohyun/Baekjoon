import java.io.*;
import java.util.*;

public class Main {
    public static int n, notBlindnessCount, blindnessCount;
    public static char[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        
        notBlindnessCount = 0;
        blindnessCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    notBlindnessCount += 1;
                    findNotBlindness(i, j);
                }
            }
        }
        
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') {
                    grid[i][j] = 'R';
                }
                if (!visited[i][j]) {
                    blindnessCount += 1;
                    findBlindness(i, j);
                }
            }
        }
        
        
        System.out.println(notBlindnessCount + " " + blindnessCount);
         
        br.close();
    }
    
    public static void findNotBlindness(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) 
                continue;
            
            if (!visited[nx][ny] && grid[x][y] == grid[nx][ny]) {
                visited[nx][ny] = true;
                findNotBlindness(nx, ny);
            }
        }
    }
    
    public static void findBlindness(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) 
                continue;
            
            if (grid[nx][ny] == 'G')
                grid[nx][ny] = 'R';
            
            if (!visited[nx][ny] && grid[x][y] == grid[nx][ny]) {
                visited[nx][ny] = true;
                findBlindness(nx, ny);
            }
        }
    }
}