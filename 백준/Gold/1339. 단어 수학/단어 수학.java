import java.io.*;
import java.util.*;

class Main {
    public static int[] alphabet = new int[26];
    public static int result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            
            for (int j = 0; j < word.length(); j++) {
                alphabet[word.charAt(j) - 'A'] += Math.pow(10, word.length() -j -1);
            }
        }
        
        Arrays.sort(alphabet);
        
        int number = 9;
        for (int i = 25; i >=0; i--) {
            if (alphabet[i] == 0)
                continue;
                
            result += alphabet[i] * number;
            number--;
        }
        
        System.out.println(result);
    }
}