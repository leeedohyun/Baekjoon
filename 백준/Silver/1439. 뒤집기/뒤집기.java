import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        
        int zero = 0;
        int one = 0;
        
        if (s.charAt(0) == '1') {
            zero++;
        } else {
            one++;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            
            if (first == '0' && second == '1') {
                zero++;
            }
            if (first == '1' && second == '0') {
                one++;
            }
        }
        
        System.out.println(Math.min(zero, one));
        
        br.close();
    }
}