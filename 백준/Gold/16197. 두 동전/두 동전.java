import java.io.*;
import java.util.*;

class Main {
    public static int n, m;
    public static char[][] board;
    public static List<Coin> coins = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = line.charAt(j);
                
                if (board[i][j] == 'o') {
                    coins.add(new Coin(i, j));
                }
            }
        }
        
        System.out.println(solution());
        
        br.close();
    }
    
    public static int solution() {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        Queue<TwoCoins> queue = new LinkedList<>();
        
        queue.offer(new TwoCoins(coins.get(0).x, coins.get(0).y, coins.get(1).x, coins.get(1).y, 0));
        
        while (!queue.isEmpty()) {
            TwoCoins now = queue.poll();
            
            if (now.count >= 10)
                break;
            
            for (int i = 0; i < 4; i++) {
                int nextX1 = now.x1 + dx[i];
                int nextY1 = now.y1 + dy[i];
                int nextX2 = now.x2 + dx[i];
                int nextY2 = now.y2 + dy[i];
                
                if (!validate(nextX1, nextY1)) {
                    nextX1 = now.x1;
                    nextY1 = now.y1;
                }
                if (!validate(nextX2, nextY2)) {
                    nextX2 = now.x2;
                    nextY2 = now.y2;
                }
                
                int flag = 0;
                if (nextX1 >= 0 && nextY1 >= 0 && nextX1 < n && nextY1 < m)
                    flag++;
                if (nextX2 >= 0 && nextY2 >= 0 && nextX2 < n && nextY2 < m) 
                    flag++;
                
                if (flag == 1)
                    return now.count + 1;
                else if (flag == 2) {
                    queue.offer(new TwoCoins(nextX1, nextY1, nextX2, nextY2, now.count + 1));
                }
            }
        }
        return -1;
    }
    
    private static boolean validate(int x, int y) {
        return !(x >= 0 && y >= 0 && x < n && y < m && board[x][y] == '#');
    }
    
    static class TwoCoins {
        int x1;
        int y1;
        int x2;
        int y2;
        int count;
        
        public TwoCoins(int x1, int y1, int x2, int y2, int count) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
        }
    }
    
    static class Coin {
        int x;
        int y;
        
        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}