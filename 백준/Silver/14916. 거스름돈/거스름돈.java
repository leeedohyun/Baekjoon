import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int number = 0;
        
        while (true) {
            if (n % 5 == 0) {
                number += n / 5;
                System.out.println(number);
                break;
            } else {
                n -= 2;
                number++;
            }
            if (n < 0) {
                System.out.println(-1);
                break;
            }
        }
        
        br.close();
    }
}