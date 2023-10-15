import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] numberOfStrokes = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String k = br.readLine();
        
        int result = 0;
        
        for (int i = 0; i < k.length(); i++) {
            result += numberOfStrokes[k.charAt(i) - 'A'];
            
            if (result >= 10) {
                result %= 10;
            }
        }
        
        if (result % 2 != 0) {
            System.out.println("I'm a winner!");
        } else {
            System.out.println("You're the winner?");
        }
        
        br.close();
    }
}