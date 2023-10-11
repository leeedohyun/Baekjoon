import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] road;
    static int[] oilPrice;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        road = new int[n - 1];
        oilPrice = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        
        int minOilPrice = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            oilPrice[i] = Integer.parseInt(st.nextToken());
            if (minOilPrice > oilPrice[i] && i != n - 1)
                minOilPrice = oilPrice[i];
        }
        
        long minCost = 0;
        for (int i = 0; i < n - 1; i++) {
            if (oilPrice[i] == minOilPrice) {
                int distance = calculateSumOfRemainingDistance(i);
                minCost += distance * oilPrice[i];
                break;
            } else {
                minCost += road[i] * oilPrice[i];
            }
        }
        
        System.out.println(minCost);
        
        br.close();
    }
    
    private static int calculateSumOfRemainingDistance(int currentLocation) {
        int distance = 0;
        for (int i = currentLocation; i < n - 1; i++) {
            distance += road[i];
        }
        return distance;
    }
}