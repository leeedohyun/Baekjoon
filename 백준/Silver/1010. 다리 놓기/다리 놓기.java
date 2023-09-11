import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] combinations;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            combinations = new int[m + 1][n + 1];
            
            sb.append(combination(m, n)).append("\n");
        }
        
        System.out.println(sb);
        
        br.close();
    }
    
    public static int combination(int n, int k) {
		for (int i = 0; i <= n; i++) {
		    for (int j = 0; j <= Math.min(i, k); j++) {
		        if (j == 0 || j == i) {
		            combinations[i][j] = 1;
		        } else {
		            combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
		        }
		    }
		}
		return combinations[n][k];
	}
}