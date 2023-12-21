import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(inputs[i]);
        }
        
        Arrays.sort(p);
        
        int result = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += p[i];
            result += sum;
        }
        System.out.println(result);
        
        br.close();
    }
}