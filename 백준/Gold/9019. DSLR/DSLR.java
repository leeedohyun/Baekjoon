import java.io.*;
import java.util.*;

public class Main {
    public static int t;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a, b);
        }
    }
    
    public static void bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        String[] result = new String[10000];
        boolean[] visited = new boolean[10000];
        
        visited[a] = true;
        queue.add(a);
        Arrays.fill(result, "");
        
        while(!queue.isEmpty() && !visited[b]) {
            int now = queue.poll();
            
            int d = (now * 2) % 10000;
            int s = now == 0 ? 9999 : now - 1;
            int l = (now % 1000) * 10 + now / 1000;
            int r = (now % 10) * 1000 + now / 10;
            
            if (!visited[d]) {
                queue.add(d);
                visited[d] = true;
                result[d] = result[now] + "D";
            }
            if (!visited[s]) {
                queue.add(s);
                visited[s] = true;
                result[s] = result[now] + "S";
            }
            if (!visited[l]) {
                queue.add(l);
                visited[l] = true;
                result[l] = result[now] + "L";
            }
            if (!visited[r]) {
                queue.add(r);
                visited[r] = true;
                result[r] = result[now] + "R";
            }
        }
        System.out.println(result[b]);
    }
}