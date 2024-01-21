import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static boolean result = false;
    static String[][] map = new String[6][6];
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
            }
        }
        
        obstacle(0);
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        br.close();
    }
    
    private static void obstacle(int depth) {
        if (depth == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (result) {
                        return;
                    }
                    if ("T".equals(map[i][j])) {
                        if (findStudent(i, j)) {
                            result = false;
                            return;
                        }
                    }
                }
            }
            result = true;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ("X".equals(map[i][j])) {
                    map[i][j] = "O";
                    depth += 1;
                    obstacle(depth);
                    depth -= 1;
                    map[i][j] = "X";
                }
            }
        }
    }
    
    private static boolean findStudent(int x, int y) {
        if (x > 0) {
            for (int i = x - 1; i >= 0; i--) {
                if ("S".equals(map[i][y])) {
                    return true;
                }
                if ("O".equals(map[i][y])) {
                    break;
                }
            }
        }
        if (x < n - 1) {
            for (int i = x + 1; i < n; i++) {
                if ("S".equals(map[i][y])) {
                    return true;
                }
                if ("O".equals(map[i][y])) {
                    break;
                }
            }
        }
        if (y > 0) {
            for (int i = y - 1; i >= 0; i--) {
                if ("S".equals(map[x][i])) {
                    return true;
                }
                if ("O".equals(map[x][i])) {
                    break;
                }
            }
        }
        if (y < n - 1) {
            for (int i = y + 1; i < n; i++) {
                if ("S".equals(map[x][i])) {
                    return true;
                }
                if ("O".equals(map[x][i])) {
                    break;
                }
            }
        }
        return false;
    }
}