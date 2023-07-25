import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static int max = 0;
    public static String[] words;
    public static boolean[] visited = new boolean[26];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new String[n];
        
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            word = word.replace("anta", "");
            word = word.replace("tica", "");
            words[i] = word;
        }
        
        if (k < 5) {
            System.out.println(0);
            return;
        }
        if (k == 26) {
            System.out.println(n);
            return;
        }
        
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        
        dfs(0, 0);
        
        System.out.println(max);
    }
    
    public static void dfs(int alph, int depth) {
        if (depth == k - 5) {
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (isRead(words[i]))
                    result++;
            }
            max = Math.max(result, max);
            return;
        }
        
        for (int i = alph; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isRead(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!visited[word.charAt(i) - 'a'])
                return false;
        }
        return true;
    }
}