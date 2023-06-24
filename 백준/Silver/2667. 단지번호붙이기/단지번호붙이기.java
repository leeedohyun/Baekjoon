import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static int apartComplexNumber = 0, houseNumber = 0;
    public static List<Integer> list = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    houseNumber = 0;
                    apartComplexNumber += 1;
                    solution(i, j);
                    list.add(houseNumber);
                }
            }
        }
        sb.append(Integer.toString(apartComplexNumber) + "\n");
        
        Collections.sort(list);
        for (int house : list) {
            sb.append(Integer.toString(house) + "\n");
        }
        System.out.println(sb);
    }

    public static void solution(int currentX, int currentY) {
        visited[currentX][currentY] = true;
        map[currentX][currentY] = apartComplexNumber;
        houseNumber += 1;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        
        for (int i = 0; i < 4; i++) {
            int nextX = currentX + dx[i];
            int nextY = currentY + dy[i];
            
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                continue;
            
            if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                visited[nextX][nextY] = true;
                map[nextX][nextY] = apartComplexNumber;
                solution(nextX, nextY);
            }
        }
    }
}