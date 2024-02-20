import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static int[][] map = new int[50][50];
    static boolean[][] cloud = new boolean[50][50];
    
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        cloud[n - 1][0] = true;
        cloud[n - 1][1] = true;
        cloud[n - 2][0] = true;
        cloud[n - 2][1] = true;
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            
            moveCloud(findCloud(), d, s);
            rain(findCloud());
            copyWater(findCloud());
            makeCloud();
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
        
        br.close();
    }
    
    private static Queue<Node> findCloud() {
        Queue<Node> q = new LinkedList<>();
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    q.add(new Node(i, j));
                }
            }
        }
        return q;
    }
    
    private static void moveCloud(Queue<Node> cloudNodes, int d, int s) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(cloud[i], false);
        }
        while (!cloudNodes.isEmpty()) {
            Node node = cloudNodes.poll();
            
            int nx = node.getX();
            int ny = node.getY();
            
            for (int i = 0; i < s; i++) {
                nx += dx[d];
                ny += dy[d];
                
                if (nx < 0) {
                    nx += n;
                } else if (nx >= n) {
                    nx -= n;
                }
                if (ny < 0) {
                    ny += n;
                } else if (ny >= n) {
                    ny -= n;
                }
            }
            cloud[nx][ny] = true;
        }
    }
    
    private static void rain(Queue<Node> cloudNodes) {
        while (!cloudNodes.isEmpty()) {
            Node cloud = cloudNodes.poll();
            map[cloud.getX()][cloud.getY()] += 1;
        }
    }
    
    private static void copyWater(Queue<Node> cloudNodes) {
        while (!cloudNodes.isEmpty()) {
            Node node = cloudNodes.poll();
            
            int count = 0;
            for (int i = 1; i < 8; i += 2) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                
                if (map[nx][ny] != 0) {
                    count++;
                }
            }
            map[node.getX()][node.getY()] += count;
        }
    }
    
    private static void makeCloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    cloud[i][j] = false;
                    continue;
                }
                if (map[i][j] >= 2) {
                    map[i][j] -= 2;
                    cloud[i][j] = true;
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