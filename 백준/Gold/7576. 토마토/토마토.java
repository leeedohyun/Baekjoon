import java.io.*;
import java.util.*;

class Tomato {
    int x;
    int y;
    
    Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[][] box;
    public static int n, m;
    public static Queue<Tomato> queue;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        queue = new LinkedList<Tomato>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                 box[i][j] = Integer.parseInt(st.nextToken());
                 if (box[i][j] == 1)
                    queue.add(new Tomato(i, j));
            }
        }
        System.out.println(solution());
    }

    public static int solution() {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
    
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            
            int x = tomato.x;
            int y = tomato.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                
                if (box[nx][ny] == 0) {
                    queue.add(new Tomato(nx, ny));
                    box[nx][ny] = box[x][y] + 1;
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0)
                    return -1;
                
                result = Math.max(result, box[i][j]);
            }
        }
        
        if (result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }
}