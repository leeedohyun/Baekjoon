import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] soldier = new int[n];
        
        String[] input = br.readLine().split(" ");
        for (int i = 0 ; i < n; i++) {
            soldier[i] = Integer.parseInt(input[i]);
        }
        
        int[] dp = new int[n];
        for (int i = 0 ; i < n; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (soldier[j] > soldier[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(n - max);
        
        br.close();
    }
}