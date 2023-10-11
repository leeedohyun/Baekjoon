import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        BigInteger[] road = new BigInteger[n - 1];
        BigInteger[] oilPrice = new BigInteger[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = new BigInteger(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oilPrice[i] = new BigInteger(st.nextToken());
        }
        
        BigInteger minCost = road[0].multiply(oilPrice[0]);
        BigInteger minOilPrice = oilPrice[0];
        for (int i = 1; i < n - 1; i++) {
            if (oilPrice[i].compareTo(minOilPrice) < 0) {
                minCost = minCost.add(road[i].multiply(oilPrice[i]));
                minOilPrice = oilPrice[i];
            } else {
                minCost = minCost.add(road[i].multiply(minOilPrice));
            }
        }
        
        System.out.println(minCost);
        
        br.close();
    }
}