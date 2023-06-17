import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static boolean[] visit;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        visit = new boolean[n];
        
        solution(n, m, 0);
    }
    
    public static void solution(int n, int m, int depth) throws IOException {
        if (depth == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                solution(n, m, depth + 1);
                visit[i] = false;
            }
        }
    }
}