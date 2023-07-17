import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static int MIN = Integer.MAX_VALUE;
    public static int MAX = Integer.MIN_VALUE;
    public static int[] numbers;
    public static int[] operator = new int[4];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        
        brute(1, numbers[0]);
        
        System.out.println(MAX);
        System.out.println(MIN);
    }
    
    public static void brute(int index, int result) {
        if (index == n) {
            MAX = Math.max(result, MAX);
            MIN = Math.min(result, MIN);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch(i) {
                    case 0:
                        brute(index + 1, result + numbers[index]);
                        break;
                    case 1:
                        brute(index + 1, result - numbers[index]);
                        break;
                    case 2:
                        brute(index + 1, result * numbers[index]);
                        break;
                    case 3:
                        brute(index + 1, result / numbers[index]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}