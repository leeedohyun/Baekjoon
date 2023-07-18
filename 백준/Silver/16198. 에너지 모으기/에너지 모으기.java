import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static int MAX = Integer.MIN_VALUE;
    public static List<Integer> energy = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            energy.add(Integer.parseInt(st.nextToken()));
        }
        
        solution(0);
        
        System.out.println(MAX);
    }
    
    public static void solution(int result) {
        if (energy.size() == 2) {
            MAX = Math.max(MAX, result);
            return;
        }
        
        for (int i = 1; i < energy.size() - 1; i++) {
            int weight = energy.get(i);
            energy.remove(i);
            solution(result + (energy.get(i - 1) * energy.get(i)));
            energy.add(i, weight);
        }
    }
}