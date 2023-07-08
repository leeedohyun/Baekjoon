import java.io.*;
import java.util.*;

class Main {
    public static List<List<Integer>> tree = new ArrayList<>();
    public static boolean[] visited;
    public static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            
            tree.get(number1).add(number2);
            tree.get(number2).add(number1);
        }
        
        dfs(1);
        
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
    
    public static void dfs(int now) {
        visited[now] = true;
        
        for (int node : tree.get(now)) {
            if(!visited[node]) {
                parent[node] = now;
                dfs(node);
            }
        }
    }
}