import java.io.*;
import java.util.*;

public class Main {
    public static int n, max = 0;
    public static int[] s;
    public static boolean[] nums;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            max += s[i];
        }
        
        nums = new boolean[max + 2];
        
        dfs(0, 0);
        
        for (int i = 1; i < nums.length; i++) {
            if (!nums[i]) {
                System.out.println(i);
                break;
            }
        }
        
        br.close();
    }
    
    public static void dfs(int sum, int depth) {
        if(depth == n){
            nums[sum] = true;
            return;
        }
        
        dfs(sum, depth + 1);
        dfs(sum + s[depth], depth + 1);
    }
}