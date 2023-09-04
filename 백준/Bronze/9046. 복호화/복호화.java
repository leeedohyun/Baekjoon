import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int[] alphabet = new int[26];
            
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) >= 'a' && line.charAt(j) <= 'z') {
                    alphabet[line.charAt(j) - 'a']++;
                }
            }
            
            int max = 0;
            for (int j = 0; j < 26; j++) {
                if (max < alphabet[j]) {
                    max = alphabet[j];
                }
            }
            
            int maxNumber = 0;
            int maxIndex = 0;
            for (int j = 0; j < 26; j++) {
                if (max == alphabet[j]) {
                    maxIndex = j;
                    maxNumber++;
                }
            }
            
            if (maxNumber == 1) {
                sb.append((char) (maxIndex + 'a')).append("\n");
            } else {
                sb.append("?").append("\n");
            }
        }
        
        System.out.println(sb);
        
        br.close();
    }
}