import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int number = i;
            int constructor = number;
            while (number >= 1) {
                constructor += number % 10;
                number /= 10;
            }
            
            if (constructor == n) {
                result = i;
                break;
            }
        }
        
        System.out.println(result);
        
        br.close();
    }
}