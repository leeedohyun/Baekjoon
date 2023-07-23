import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] board;
    public static boolean[] visited = new boolean[26];
    public static int max = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }
        
        visited[board[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }
    
    public static void dfs(int x, int y, int result) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        max = Math.max(max, result);
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                continue;
           
            if (!visited[board[nextX][nextY]]) {
                visited[board[nextX][nextY]] = true;
                dfs(nextX, nextY, result + 1);
                visited[board[nextX][nextY]] = false;
            }
        }
    }
}