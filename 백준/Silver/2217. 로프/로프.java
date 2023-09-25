import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] rope, arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        rope = new int[n];
        arr = new int[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(rope);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(rope[i] * (n - i), max);
        }
        
        System.out.println(max);
        
        br.close();
    }
}