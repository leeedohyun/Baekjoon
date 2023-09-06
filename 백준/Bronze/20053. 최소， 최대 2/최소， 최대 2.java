import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
            while (st.hasMoreTokens()) {
                int now = Integer.parseInt(st.nextToken());
                
                if (max < now)
                    max = now;
                    
                if (min > now)
                    min = now;
            }
            sb.append(min).append(" ").append(max);
            sb.append("\n");
        }
        
        System.out.println(sb);
        
        br.close();
    }
}