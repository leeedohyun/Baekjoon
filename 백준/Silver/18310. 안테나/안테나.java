import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] house = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(house);
        
        System.out.println(house[(n - 1) / 2]);
        br.close();
    }
}