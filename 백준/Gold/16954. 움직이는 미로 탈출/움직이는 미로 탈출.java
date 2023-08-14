import java.io.*;
import java.util.*;

public class Main {
    public static char[][] map = new char[8][8];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 8; i++){
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        if (bfs(7, 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        br.close();
    }
    
    public static boolean bfs(int x, int y) {
        int[] dx = {0, 0, -1, 1, -1, -1, 1, 1, 0};
        int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1, 0};
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        
        int previousTime = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            if (map[now.x][now.y] == '#')
                return false;
            
            if (now.x == 0 && now.y == 7)
                return true;
            
            if (now.time != previousTime) {
                for (int i = 7; i >= 0; i--) {
                    for (int j = 0; j < 8; j++) {
                        if (i > 0 && map[i - 1][j] == '#') {
                            map[i][j] = '#';
                            map[i - 1][j] = '.';
                        }
                    }
                }
            }
            
            for (int i = 0; i < 9; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8)
                    continue;
                
                if (nx > 0 && map[nx][ny] != '#' && map[nx - 1][ny] != '#') {
                    countTime(queue, nx, ny, now.time);
                }
                if (nx == 0 && map[nx][ny] != '#') {
                    countTime(queue, nx, ny, now.time);
                }
            }
            previousTime = now.time;
        }
        return false;
    }
    
    private static void countTime(Queue<Node> queue, int x, int y, int time) {
        if (time == 0)
            queue.add(new Node(x, y, time + 1));
        else
            queue.add(new Node(x, y, time + 2));
    }
    
    static class Node {
        int x;
        int y;
        int time;
        
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}