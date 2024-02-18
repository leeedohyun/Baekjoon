import java.io.*;
import java.util.*;

public class Main {
    
    static int r, c, n;
    static Bomb[][] map = new Bomb[200][200];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = new Bomb(line.charAt(j), 0);
            }
        }
        
        int time = 1;
        boolean isExplode = false;
        while (time < n) {
            time++;
            if (!isExplode) {
                plant(time);
            } else {
                explode(time);
            }
            isExplode = !isExplode;
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j].getStatus());
            }
            System.out.println();
        }
        
        br.close();
    }
    
    private static void plant(int time) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Bomb bomb = map[i][j];
                if (bomb.getStatus() == '.') {
                    map[i][j] = new Bomb('O', time);
                }
            }
        }
    }
    
    private static void explode(int time) {
        boolean[][] checked = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Bomb bomb = map[i][j];
                
                if (bomb.getStatus() == 'O' && time - bomb.getTime() >= 3) {
                    checked[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                            checked[nx][ny] = true;
                        }
                    }
                } 
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (checked[i][j]) {
                    map[i][j] = new Bomb('.', 0);
                }
            }
        }
    }
    
    static class Bomb {
        private char status;
        private int time;
        
        public Bomb(char status, int time) {
            this.status = status;
            this.time = time;
        }
        
        public char getStatus() {
            return status;
        }
        
        public int getTime() {
            return time;
        }
    }
}