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
        
        System.out.println(bfs(7, 0));
        
        br.close();
    }
    
    public static int bfs(int x, int y) {
        int[] dx = {0, 0, -1, 1, -1, -1, 1, 1, 0};
        int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1, 0};
        
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited;
        
        queue.add(new Node(x, y));
    
        while (!queue.isEmpty()) {
            int size = queue.size();
            visited = new boolean[8][8];
            
            for (int i = 0; i < size; i++) {
                Node now = queue.poll();
                
                if (map[now.x][now.y] == '#')
                    continue;
                
                if (now.x == 0 && now.y == 7)
                    return 1;
                
                for (int j = 0; j < 9; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                
                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8 || map[nx][ny] == '#')
                        continue;
                    
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
            down();
        }
        return 0;
    }
    
    private static void down() {
        for (int i = 7; i > 0; i--) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = map[i - 1][j];
            }
        }
        Arrays.fill(map[0], '.');
    }
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}