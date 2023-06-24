import java.io.*;
import java.util.*;

public class Main {
    public static int[] numbers;
    public static int[] arr;
    public static int n, m;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        visited = new boolean[n];
        arr = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        solution(numbers, 0);
        System.out.println(sb);
    }

    public static void solution(int[] data, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        Arrays.sort(data);

        int before = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
                
            if (before != data[i]) {
                visited[i] = true;
                arr[depth] = data[i];
                before = data[i];
                solution(data, depth + 1);
                visited[i] = false;
            }
        } 
    }
}