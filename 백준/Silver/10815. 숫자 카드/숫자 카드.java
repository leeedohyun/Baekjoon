import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static int[] cards;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cards);
        
        m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken()))) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append(" ");
        }
        
        System.out.println(sb);
        
        br.close();
    }
    
    private static boolean binarySearch(int number) {
        int start = 0;
        int end = n - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (cards[mid] == number) {
                return true;
            } else if (cards[mid] < number) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}