import java.io.*;
import java.util.*;

public class Main {
    public static Integer[] numbers;
    public static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        numbers = new Integer[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        if (solution(numbers)) {
            for (int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
        } else {
            sb.append("-1");
        }
        
        System.out.println(sb);
    }

    public static boolean solution(Integer[] data) {
        int i = data.length - 1;
        // data[i - 1] > data[i]
        while (i > 0 && data[i - 1] <= data[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }

        int j = data.length - 1;
        // date[i - 1] > data[j]
        while (data[i - 1] <= data[j]) {
            j -= 1;
        }

        int tmp = data[j];
        data[j] = data[i - 1];
        data[i - 1] = tmp;

        Arrays.sort(data, i, data.length, Collections.reverseOrder());
        return true;
    }
}