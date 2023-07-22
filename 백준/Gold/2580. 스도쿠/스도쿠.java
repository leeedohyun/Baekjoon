import java.io.*;
import java.util.*;

public class Main {
    public static int[][] sudoku = new int[9][9];
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
    }
    
    public static void dfs(int x, int y) {
        if (y == 9) {
            dfs(x + 1, 0);
            return;
        }
        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        
        if (sudoku[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (validateAll(x, y, i)) {
                    sudoku[x][y] = i;
                    dfs(x, y + 1);
                }
            }
            sudoku[x][y] = 0;
            return;
        }
        dfs(x, y + 1);
    }
    
    public static boolean validateAll(int x, int y, int value) {
        return validateRow(x, y, value) && validateColumn(x, y, value) && validateBox(x, y, value);
    }
    
    private static boolean validateRow(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == value)
                return false;
        }
        return true;
    }
    
    private static boolean validateColumn(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == value)
                return false;
        }
        return true;
    }
    
    private static boolean validateBox(int x, int y, int value) {
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++){
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}