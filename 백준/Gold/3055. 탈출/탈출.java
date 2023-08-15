import java.io.*;
import java.util.*;

public class Main {
    public static int r, c;
    public static char[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        
        int x = 0, y = 0;
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        int result = bfs(x, y);
        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
        
        br.close();
    }
    
    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited;
        
        queue.add(new Node(x, y));
        
        int time = 0;
        while (!queue.isEmpty()) {
            expandWater();
            
            int size = queue.size();
            visited = new boolean[r][c];
            
            for (int i = 0; i < size; i++) {
                Node now = queue.poll();
                
                if (map[now.x][now.y] == 'D')
                    return time;
                
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                        continue;
                    
                    if (!visited[nx][ny] && map[nx][ny] != 'X') {
                        if (map[nx][ny] != '*') {
                            visited[nx][ny] = true;
                            queue.add(new Node(nx, ny));
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }
    
    private static void expandWater() {
        boolean[][] waterVisited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!waterVisited[i][j] && map[i][j] == '*') {
                    waterVisited[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                            
                        if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                            continue;
                
                        if (!waterVisited[nx][ny] && map[nx][ny] == '.') {
                            waterVisited[nx][ny] = true;
                            map[nx][ny] = '*';
                        }
                    }
                }
            }
        }
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