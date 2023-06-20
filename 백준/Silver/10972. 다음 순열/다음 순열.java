import java.io.*;
import java.util.*;

public class Main {
    public static int[] numbers;
    public static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        if (solution(numbers)) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    public static boolean solution(int[] data) {
        // data[i - 1] < data[i]를 만족하는 가장 큰 i 찾기
        int i = data.length - 1;
        while (i > 0 && data[i - 1] >= data[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        
        // j >= i 이면서 data[j] > data[i - 1]를 만족하는 가장 큰 j 찾기
        int j = data.length - 1;
        while (data[i - 1] >= data[j]) {
            j -= 1;
        }
        
        // swap
        int tmp = data[j];
        data[j] = data[i - 1];
        data[i - 1] = tmp;
        
        // i이후 정렬
        Arrays.sort(data, i, data.length);
        return true;
    }
}