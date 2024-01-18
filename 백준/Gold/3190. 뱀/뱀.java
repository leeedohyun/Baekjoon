import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] map = new int[101][101];
    static ArrayList<Node> info = new ArrayList<>();
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            map[x][y] = 2;
        }
        
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            
            info.add(new Node(time, direction));
        }
        
        int time = 0;
        int directionIndex = 0;
        int index = 0;
        int x = 1;
        int y = 1;
        map[x][y] = 1;
        
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x, y));
        
        while (true) {
            int nx = x + dx[directionIndex];
            int ny = y + dy[directionIndex];
            
            if (nx <= 0 || nx > n || ny <= 0 || ny > n) {
                time += 1;
                break;
            }
            if (map[nx][ny] == 1) {
                time += 1;
                break;
            }
            
            if (map[nx][ny] == 2) {
                map[nx][ny] = 1;
                q.add(new Position(nx, ny));
            } else {
                map[nx][ny] = 1;
                q.add(new Position(nx, ny));
                Position prev = q.poll();
                map[prev.getX()][prev.getY()] = 0;
            }
            
            time += 1;
            x = nx;
            y = ny;
            
            if (index < l && time == info.get(index).getTime()) {
                directionIndex = turn(directionIndex, info.get(index).getDirection());
                index += 1;
            }
        }
        
        System.out.println(time);
        
        br.close();
    }
    
    private static int turn(int index, String direction) {
        if ("L".equals(direction)) {
            return (index == 0) ? 3: index - 1;
        }
        return (index + 1) % 4;
    }
    
    static class Node {
        private int time;
        private String direction;
        
        public Node(int time, String direction) {
            this.time = time;
            this.direction = direction;
        }
        
        public int getTime() {
            return time;
        }
        
        public String getDirection() {
            return direction;
        }
    }
    
    static class Position {
        private int x;
        private int y;
        
        public Position(int x, int y) {
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