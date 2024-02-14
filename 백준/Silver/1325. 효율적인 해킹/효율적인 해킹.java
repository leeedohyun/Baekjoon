import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] result;
    static boolean[] visited;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        result = new int[n + 1];
        graph = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
        }
        
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                sb.append(i + " ");
            }
        }
        
        System.out.println(sb);
        
        br.close();
    }
    
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int i = 0; i < graph[now].size(); i++) {
                if (!visited[graph[now].get(i)]) {
                    result[graph[now].get(i)] += 1;
                    visited[graph[now].get(i)] = true;
                    q.add(graph[now].get(i));
                }
            }
        }
    }
}