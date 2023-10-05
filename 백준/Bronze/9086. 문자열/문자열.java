import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            
            if (s.length() <= 1) {
                sb.append(s + s).append("\n");
            } else {
                sb.append(s.substring(0, 1) + s.substring(s.length() - 1, s.length())).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}