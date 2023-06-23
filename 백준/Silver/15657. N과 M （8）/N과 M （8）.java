import java.io.*;
import java.util.*;

public class Main {
    public static int[] numbers;
    public static int[] arr;
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        arr = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        solution(numbers, 0, 0);
        System.out.println(sb);
    }

    public static void solution(int[] data, int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        Arrays.sort(data);

        for (int i = start; i < n; i++) {
            arr[depth] = data[i];
            solution(data, i, depth + 1);
        } 
    }
}