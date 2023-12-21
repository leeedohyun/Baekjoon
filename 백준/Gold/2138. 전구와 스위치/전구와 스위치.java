import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static int[] a, b, c;
        
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        a = new int[n];
        b = new int[n];
        
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            a[i] = Character.getNumericValue(input.charAt(i));
        }
        
        input = br.readLine();
        for (int i = 0; i < n; i++) {
            b[i] = Character.getNumericValue(input.charAt(i));
        }
        
        c = Arrays.copyOf(a, a.length);
        c[0] = 1 - a[0];
        c[1] = 1 - a[1];
        
        int result1 = 1;
        int result2 = 0;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] != b[i - 1]) {
                swap(a, i);
                result2 += 1;
            }
            if (c[i - 1] != b[i - 1]) {
                swap(c, i);
                result1 += 1;
            }
        }
        
        if (!Arrays.equals(a, b)) result2 = Integer.MAX_VALUE;
        if (!Arrays.equals(c, b)) result1 = Integer.MAX_VALUE;
        
        if (result1 == Integer.MAX_VALUE && result2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(result1, result2));
        }
        
        br.close();
    }
    
    private static void swap(int[] a, int x) {
        if (x == n - 1) {
            a[x - 1] = 1 - a[x - 1];
            a[x] = 1 - a[x];
            return;
        }
        for (int i = x - 1; i <= x + 1; i++) {
            a[i] = 1 - a[i];
        }
    }
}