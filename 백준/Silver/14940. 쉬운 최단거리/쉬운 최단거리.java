import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static int[][] map = new int[1000][1000];
    static int[][] distance = new int[1000][1000];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int targetX = 0;
        int targetY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                }
                if (map[i][j] == 0) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = -1;
                }
            }
        }
        
        bfs(targetX, targetY);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
        br.close();
    }
    
    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        distance[x][y] = 0;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0 ,-1, 0, 1};
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                
                if (distance[nx][ny] == -1 && map[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    distance[nx][ny] = distance[node.getX()][node.getY()] + 1;
                }
            }
        }
    }
    
    static class Node {
        private int x;
        private int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
    }
}