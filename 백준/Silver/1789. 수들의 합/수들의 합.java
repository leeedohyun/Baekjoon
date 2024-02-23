import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long s = Long.parseLong(br.readLine());
        
        System.out.println(binarySearch(s));
        
        br.close();
    }
    
    private static long binarySearch(long s) {
        long start = 0;
        long end = s;
        long max = 0;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = mid * (mid + 1) / 2;
            
            if (sum == s) {
                return mid;
            } else if (sum < s) {
                start = mid + 1;
                max = mid;
            } else {
                end = mid - 1;
            }
        }
        return max;
    }
}