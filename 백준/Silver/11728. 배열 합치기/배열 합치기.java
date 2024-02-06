import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] data = new int[n + m];
    
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            data[n + i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(data);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            sb.append(data[i] + " ");
        }
        
        System.out.println(sb);
        
        br.close();
    }
}