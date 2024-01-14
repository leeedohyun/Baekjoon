import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        int length = s.length();
        int right = 0;
        int left = 0;
        for (int i = 0; i < length / 2; i++) {
            right += s.charAt(length - i - 1) - '0';
            left += s.charAt(i) - '0';
        }
        
        if (right == left) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
        
        br.close();
    }
}