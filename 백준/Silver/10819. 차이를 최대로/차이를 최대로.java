import java.io.*;
import java.util.*;

public class Main {
    public static int n, result = 0;
    public static int[] data, arr;
    public static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        data = new int[n];
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        
        solution(0);
        System.out.println(result);
    }

    public static void solution(int depth) {
        int sum = 0;
        
        if (depth == n) {
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            result = Math.max(sum, result);
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = data[i];
                solution(depth + 1);
                visited[i] = false;
            }
        }
    }
}