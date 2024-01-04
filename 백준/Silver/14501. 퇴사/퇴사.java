import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            
            data[i][0] = Integer.parseInt(input[0]);
            data[i][1] = Integer.parseInt(input[1]);
        }
        
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (data[i][0] + i > n) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[i] + data[i][1] + dp[data[i][0] + i]);
            }
        }
        System.out.println(dp[0]);
        
        br.close();
    }
}