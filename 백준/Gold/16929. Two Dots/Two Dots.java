import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static char[][] board;
    public static boolean[][] visited;
    public static int[][] count;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new char[n][m];
        count = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (traversal(i, j, board[i][j], 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    public static boolean traversal(int x, int y, int color, int length) {
        if(visited[x][y]) return length - count[x][y] >= 4;

        visited[x][y] = true;
        count[x][y] = length;
    
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
              
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            
            if (board[nx][ny] == color) {
                if (traversal(nx, ny, color, length + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}