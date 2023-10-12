import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] energyDrink = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            energyDrink[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(energyDrink);
        
        double result = energyDrink[n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            result += (double) energyDrink[i] / 2;
        }
        
        System.out.println(result);
        
        br.close();
    }
}