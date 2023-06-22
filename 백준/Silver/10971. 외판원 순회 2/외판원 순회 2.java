import java.io.*;
import java.util.*;

class Main {
    static int n, result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            solution(i, i, 0);
        }
        System.out.println(result);
    }
    
    private static void solution(int start, int now, int cost) {
        if (allVisited()) {
            if (map[now][start] != 0) {
                result = Math.min(result, cost + map[now][start]);
            }
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                solution(start, i, cost + map[now][i]);
                visited[i] = false;
            }
        }
    }
    
    private static boolean allVisited() {
        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}