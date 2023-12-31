import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
        
        int result = 0;
        while (q.size() > 1) {
            int first = q.poll();
            int second = q.poll();
            int sum = first + second;
            q.add(sum);
            result += sum;
        }
        System.out.println(result);
        
        br.close();
    } 
}