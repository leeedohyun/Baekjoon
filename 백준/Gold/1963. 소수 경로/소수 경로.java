import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static boolean[] notPrime = new boolean[10000];
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i <= 9999; i++) {
            for (int j = 2 * i; j <= 9999; j += i) {
                notPrime[j] = true;
            }
        }
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int result = bfs(a, b);
            
            if (result == -1) {
                sb.append("Impossible\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        
        System.out.println(sb);
        
        br.close();
    }
    
    public static int bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[10000];
        int[] d = {1000, 100, 10, 1};
        int count = 0;
        
        q.add(a);
        visited[a] = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                
                if (now == b) {
                    return count;
                }
                
                int[] digit = new int[4];
                for (int j = 0; j < 4; j++) {
                    digit[j] = now / d[j];
                    now %= d[j];
                }
                
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k <= 9; k++) {
                        if (j == 0 && k == 0)
                            continue;
                        
                        int tmp = digit[j];
                        digit[j] = k;
                        int next = change(digit);
                        digit[j] = tmp;
                        
                        if (!visited[next] && !notPrime[next]) {
                            q.add(next);
                            visited[next] = true;
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
    
    private static int change(int[] arr) {
        return arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
    }
}