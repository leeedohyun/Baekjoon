import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Integer[] originalTips = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            originalTips[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(originalTips, Comparator.reverseOrder());
        
        long sumOfTips = 0;
        for (int i = 0; i < n; i++) {;
            if (originalTips[i] - i <= 0) {
                break;
            }
            
            sumOfTips += originalTips[i] - i;
        }
        
        System.out.println(sumOfTips);
        
        br.close();
    }
}