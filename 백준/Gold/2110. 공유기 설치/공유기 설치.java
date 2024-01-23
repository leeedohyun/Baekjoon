import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(data);
        
        int start = 1;
        int end = data[n - 1] - data[0];
        int result = 0;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int value = data[0];
            int count = 1;
            
            for (int i = 0; i < n; i++) {
                if (data[i] >= value + mid) {
                    value = data[i];
                    count += 1;
                }
            }
            
            if (count >= c) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        
        System.out.println(result);
        
        br.close();
    }
}