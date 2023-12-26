import java.io.*;
import java.util.*;

public class Main {
    
    static int n, k;
    static int[][] map;
    static Queue<Node> q = new LinkedList<>();
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                
                if (map[i][j] != 0) {
                    q.add(new Node(i, j, 0));
                }
            }
        }
        
        line = br.readLine().split(" ");
        
        int s = Integer.parseInt(line[0]);
        int x = Integer.parseInt(line[1]) - 1;
        int y = Integer.parseInt(line[2]) - 1;
        
        
        int[][] timeTable = new int[n][n];
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.getTime() >= s) {
                    break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[now.getX()][now.getY()];
                    timeTable[nx][ny] = timeTable[now.getX()][now.getY()] + 1;
                    q.add(new Node(nx, ny, now.getTime() + 1));
                } else {
                    if (timeTable[nx][ny] == now.getTime() + 1) {
                        map[nx][ny] = Math.min(map[nx][ny], map[now.getX()][now.getY()]);
                    }
                }
            }
        }
        
        System.out.println(map[x][y]);
        
        br.close();
    }
    
    static class Node {
        
        private int x;
        private int y;
        private int time;
        
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public int getTime() {
            return time;
        }
    }
}