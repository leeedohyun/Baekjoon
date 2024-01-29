import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited = new boolean[101];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        visited[1] = true;
        dfs(1);
        
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (visited[i]) {
                count += 1;
            }
        }
        
        System.out.println(count);
        
        br.close();
    }
    
    private static void dfs(int start) {
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!visited[graph.get(start).get(i)]) {
                visited[graph.get(start).get(i)] = true;
                dfs(graph.get(start).get(i));
            }
        }
    }
}