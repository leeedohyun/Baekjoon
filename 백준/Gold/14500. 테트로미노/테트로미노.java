import java.io.*;
import java.util.*;

class Main {
    public static int n, m;
    public static int max = Integer.MIN_VALUE;
    public static int[][] paper;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, paper[i][j], 1);
                visited[i][j] = false;
            }
        }
        
        System.out.println(max);
        
        br.close();
    }
    
    public static void dfs(int x, int y, int result, int count) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        if (count == 4) {
            max = Math.max(max, result);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];
            
            if (nowX < 0 || nowX >= n || nowY < 0 || nowY >= m)
                continue;
                
            if (!visited[nowX][nowY]) {
                if (count == 2) {
                    visited[nowX][nowY] = true;
					dfs(x, y, result + paper[nowX][nowY], count + 1);
					visited[nowX][nowY] = false;
                }
                
                visited[nowX][nowY] = true;
                dfs(nowX, nowY, result + paper[nowX][nowY], count + 1);
                visited[nowX][nowY] = false;
            }
        }
    }
}