import java.io.*;
import java.util.*;

public class Main {
    
    static int n, result = 0;
    static Egg[] eggs = new Egg[8];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        backtracking(0, 0);
        System.out.println(result);
        
        br.close();
    }
    
    private static void backtracking(int depth, int value) {
        if (depth == n || value == n - 1) {
            result = Math.max(result, value);
            return;
        }
        
        if (eggs[depth].getS() <= 0) {
            backtracking(depth + 1, value);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (i == depth) {
                continue;
            }
            
            if (eggs[i].getS() > 0) {
                eggs[i].breakEgg(eggs[depth].getW());
                eggs[depth].breakEgg(eggs[i].getW());
                backtracking(depth + 1, value + (eggs[i].getS() <= 0 ? 1 : 0) + (eggs[depth].getS() <= 0 ? 1 : 0));
                eggs[i].plus(eggs[depth].getW());
                eggs[depth].plus(eggs[i].getW());
            }
        }
    }
    
    static class Egg {
        private int s;
        private int w;
        
        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
        
        public void breakEgg(int w) {
            s -= w;
        }
        
        public void plus(int w) {
            s += w;
        }
        
        public int getS() {
            return s;
        }
        
        public int getW() {
            return w;
        }
    }
}