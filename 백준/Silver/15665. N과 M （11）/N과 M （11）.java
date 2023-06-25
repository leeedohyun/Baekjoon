import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> numbers;
    public static int[] arr;
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new ArrayList<>();
        arr = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        solution(0);
        System.out.println(sb);
    }

    public static void solution(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        Collections.sort(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            arr[depth] = numbers.get(i);
            solution(depth + 1);

        } 
    }
}