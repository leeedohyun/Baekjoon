import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            LinkedList<int[]> q = new LinkedList<>();
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                q.add(new int[] {i, Integer.parseInt(st.nextToken())});
            }
            
            int count = 0;
            
            while (!q.isEmpty()) {
                int[] front = q.poll();
                
                boolean isMax = true;
                
                for (int i = 0; i < q.size(); i++) {
                    if (front[1] < q.get(i)[1]) {
                        q.add(front);
                        for (int j = 0; j < i; j++) {
                            q.add(q.poll());
                        }
                        
                        isMax = false;
                        break;
                    }
                }
                
                if (isMax) {
                    count++;
                    if (front[0] == m) {
                        break;
                    }
                }
            }
            System.out.println(count);
        }
        
        br.close();
    }
}