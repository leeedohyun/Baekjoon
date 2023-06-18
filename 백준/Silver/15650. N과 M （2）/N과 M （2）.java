import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int n, m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        solution(1, 0);
    }

    public static void solution(int start, int depth) {
        if (depth == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            solution(i + 1, depth + 1);
        }
    }
}