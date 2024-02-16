import java.io.*;
import java.util.*;

public class Main {
    
    private static final int MAX = 100000000;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] bigJump = new int[n - 1];
        int[] smallJump = new int[n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            smallJump[i] = Integer.parseInt(st.nextToken());
            bigJump[i] = Integer.parseInt(st.nextToken());
        }
        
        int k = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = MAX;
            dp[i][1] = MAX;
        }
        
        if (n >= 3) {
            dp[1][0] = smallJump[0];
            dp[2][0] = Math.min(bigJump[0], dp[1][0] + smallJump[1]);
            for (int i = 3; i < n; i++) {
		        dp[i][0] = Math.min(dp[i - 1][0] + smallJump[i - 1], dp[i - 2][0] + bigJump[i - 2]);
                dp[i][1] = Math.min(Math.min(dp[i - 1][1] + smallJump[i - 1], dp[i - 2][1] + bigJump[i - 2]), dp[i - 3][0] + k);
            }
        } else if (n == 2) {
            dp[1][0] = smallJump[0];
        } else {
            dp[0][0] = 0;
        }
        
        System.out.println(Math.min(dp[n - 1][0], dp[n - 1][1]));
        
        br.close();
    }
}