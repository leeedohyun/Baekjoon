import java.io.*;
import java.util.*;

public class Main {
    
    private static final int INF = (int) 1e9;
    
    static int n, m;
    static int[][] graph = new int[101][101];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= 100; i++) {
            Arrays.fill(graph[i], INF);
        }
        
        for (int i = 1 ; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph[start][end] = Math.min(graph[start][end], cost);
        }
        
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
        
        for (int i = 1 ; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] >= INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
        
        br.close();
    }
}