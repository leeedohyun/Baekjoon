import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] data = new int[n];
        
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int odd = 0;
        int even = 0;
        
        if (data[0] % 2 == 0) {
            even += 1;
        } else {
            odd += 1;
        }
        int result = even;
        
        while (right >= left) {
            if (odd > k) {
                if (data[left] % 2 == 0) {
                    even -= 1;
                } else {
                    odd -= 1;
                }
                left += 1;
            } else {
                right += 1;
                if (right >= n) {
                    break;
                }
                if (data[right] % 2 == 0) {
                    even += 1;
                } else {
                    odd += 1;
                }
                result = Math.max(result, even);
            }
        }
        System.out.println(result);
        
        br.close();
    }
}