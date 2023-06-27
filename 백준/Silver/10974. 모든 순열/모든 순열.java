import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static boolean[] visited; 
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n];
        
        solution(0);
        System.out.println(sb);
    }
    
    public static void solution(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                solution(depth + 1);
                visited[i] = false;
            }
        }
    }
}