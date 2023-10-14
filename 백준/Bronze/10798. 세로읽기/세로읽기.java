import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        char[][] words = new char[5][15];
        
        for (int i = 0; i < 5; i++) {
            char[] inputWords = br.readLine().toCharArray();
            for (int j = 0; j < inputWords.length; j++) {
                words[i][j] = inputWords[j];
            }
        }
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (words[j][i] == '\u0000')
                    continue;
                
                sb.append(words[j][i]);
            }
        }
        
        System.out.println(sb);
        
        br.close();
    }
}