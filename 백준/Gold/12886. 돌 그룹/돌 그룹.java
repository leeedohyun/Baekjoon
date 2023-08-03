import java.io.*;
import java.util.*;

public class Main {
    public static int sum;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        sum = a + b + c;
        visited = new boolean[1501][1501];
        
        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }
        
        bfs(a, b, c);
        
        br.close();
    }
    
    public static void bfs(int a, int b, int c) {
        Queue<Rocks> queue = new LinkedList<>();
        
        queue.add(new Rocks(a, b, c));
        visited[a][b] = true;
        
        while (!queue.isEmpty()) {
            Rocks now = queue.poll();
            
            if (compareRocks(now)) {
                System.out.println(1);
                return;
            }
            
            int[] rocks = {now.a, now.b, now.c};
            
            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
	                if (rocks[i] < rocks[j]) {
	                    int x = rocks[i];
	                    int y = rocks[j];
	                    
	                    if (!visited[x + x][y - x]) {
	                        queue.add(new Rocks(x + x, y - x, sum - (x + y)));
	                        visited[x + x][y - x] = true;
	                    }
	                }
	                if (rocks[i] > rocks[j]) {
	                    int x = rocks[j];
	                    int y = rocks[i];
	                    
	                    if (!visited[x + x][y - x]) {
	                        queue.add(new Rocks(x + x, y - x, sum - (x + y)));
	                        visited[x + x][y - x] = true;
	                    }
	                }
                }
	        }
        }
        System.out.println(0);
    }
    
    private static boolean compareRocks(Rocks rocks) {
        return rocks.a == rocks.b && rocks.b == rocks.c;
    }
    
    static class Rocks {
        int a;
        int b;
        int c;
        
        public Rocks(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}