import java.io.*;
import java.util.*;

 public class Main {
    public static int n, m;
    public static int[][] map;
    public static boolean[][][] visited;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m][2];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        
        System.out.println(bfs());
        
        br.close();
    }
    
    public static int bfs() {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            if (now.x == n - 1 && now.y == m - 1) {
                return now.moveNumber;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                
                if (!visited[nx][ny][now.breakingNumber]) {
                    visited[nx][ny][now.breakingNumber] = true;
                    
                    if (map[nx][ny] == 0)
                        queue.add(new Node(nx, ny, now.moveNumber + 1, now.breakingNumber));
                    if (map[nx][ny] == 1 && now.breakingNumber == 0)
                        queue.add(new Node(nx, ny, now.moveNumber + 1, now.breakingNumber + 1));
                }
            }
        }
        return -1;
    }
    
    static class Node {
        int x;
        int y;
        int moveNumber;
        int breakingNumber;
        
        public Node(int x, int y, int moveNumber, int breakingNumber) {
            this.x = x;
            this.y = y;
            this.moveNumber = moveNumber;
            this.breakingNumber = breakingNumber;
        }
    }
}