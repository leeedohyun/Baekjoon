import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] maze;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        maze = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                maze[j][i] = Character.getNumericValue(line.charAt(j));
            }
        }
        
        if (maze[0][0] != 0)
            return;
        
        System.out.println(bfs());
    }
    
    public static int bfs() {
        PriorityQueue<Room> queue = new  PriorityQueue<>();
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        queue.add(new Room(0, 0, 0));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Room now = queue.poll();
            
            if (now.x == n - 1 && now.y == m - 1)
                return now.breakingNumber;
            
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;
                    
                if (!visited[nextX][nextY] && maze[nextX][nextY] == 1) {
                    queue.add(new Room(nextX, nextY, now.breakingNumber + 1));
                    visited[nextX][nextY] = true;
                }
                if (!visited[nextX][nextY] && maze[nextX][nextY] == 0) {
                    queue.add(new Room(nextX, nextY, now.breakingNumber));
                    visited[nextX][nextY] = true;
                }
            }
        }
        return 0;
    }
    
    static class Room implements Comparable<Room> {
        int x;
        int y;
        int breakingNumber;
        
        public Room(int x, int y, int breakingNumber) {
            this.x = x;
            this.y = y;
            this.breakingNumber = breakingNumber;
        }
        
        @Override
        public int compareTo(Room room) {
            return this.breakingNumber - room.breakingNumber;
        }
    }
}