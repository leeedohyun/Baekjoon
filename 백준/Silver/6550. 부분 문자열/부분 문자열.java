import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            
            StringTokenizer st = new StringTokenizer(line);
            
            String s = st.nextToken();
            String t = st.nextToken();
            
            int index = 0;
            
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(index)) {
                    index++;
                }
                if (index == s.length()) {
                    break;
                }
            }
            
            if (index == s.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        
        br.close();
    }
}