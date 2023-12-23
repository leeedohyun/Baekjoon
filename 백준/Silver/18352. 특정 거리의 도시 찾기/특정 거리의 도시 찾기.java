import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m, k, x;
    static List<List<Integer>> map = new ArrayList<>();
    static int[] distance;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        k = Integer.parseInt(inputs[2]);
        x = Integer.parseInt(inputs[3]);
        
        distance = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            
            map.get(start).add(end);
        }
        if (!bfs(x)) {
            System.out.println(-1);
        }
         
        br.close();
    }
    
    private static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        distance[start] = 0;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : map.get(now)) {
                if (distance[next] == Integer.MAX_VALUE) {
                    distance[next] = distance[now] + 1;
                    q.add(next);
                }
            }
        }
        
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }
        return flag;
    }
}