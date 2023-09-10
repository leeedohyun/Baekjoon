import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int stairsNumber = Integer.parseInt(br.readLine());
        int[] stairs = new int[stairsNumber + 1];
        int[] dp = new int[stairsNumber + 1];
        
        for (int i = 1; i <= stairsNumber; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = stairs[1];
        
        if (stairsNumber >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        
        for (int i = 3; i <= stairsNumber; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }
        
        System.out.println(dp[stairsNumber]);
        
        br.close();
    }
}