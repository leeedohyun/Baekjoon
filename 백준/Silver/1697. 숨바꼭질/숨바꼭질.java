import java.io.*;
import java.util.*;

class Main {
    public static int n, k;
    public static int[] time = new int[100001];
    public static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs(n));
    }
    
    public static int bfs(int number) {
        queue.add(number);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            if(now != k) {
                walk(now);
                teleport(now);
            } else {
                return time[now];
            }
        }
        return -1;
    }
    
    public static void walk(int now) {
        int[] dx = {-1, 1};
        
        for (int i = 0; i < 2; i++) {
            int next = now + dx[i];
            
            if (next >= 0 && next <= 100000 && time[next] == 0) {
                time[next] = time[now] + 1;
                queue.add(next);
            }
        }
    }
    
    public static void teleport(int now) {
        int next = now * 2;
        
        if (next <= 100000 && time[next] == 0) {
            time[next] = time[now] + 1;
            queue.add(next);
        }
    }
}