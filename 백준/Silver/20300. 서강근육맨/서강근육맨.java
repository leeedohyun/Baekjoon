import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        BigInteger[] muscleLoss = new BigInteger[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            muscleLoss[i] = new BigInteger(st.nextToken());
        }
        
        Arrays.sort(muscleLoss);
        
        BigInteger m = new BigInteger("0");
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                if (m.compareTo(muscleLoss[i].add(muscleLoss[n - i - 1])) == -1) {
                    m = muscleLoss[i].add(muscleLoss[n - i - 1]);
                }
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                if (m.compareTo(muscleLoss[i].add(muscleLoss[n - i - 2])) == -1) {
                    m = muscleLoss[i].add(muscleLoss[n - i - 2]);
                }
            }
            
            if (m.compareTo(muscleLoss[n - 1]) == -1) {
                m = muscleLoss[n - 1];
            }
        }
        
        System.out.println(m);
        
        br.close();
    }
}