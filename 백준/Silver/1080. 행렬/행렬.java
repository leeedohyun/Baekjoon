import java.io.*;

public class Main {
    
    static int n, m;
    static int[][] a;
    static int[][] b;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        
        a = new int[n][m];
        b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        
        int result = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    convert(i, j);
                    result++;
                }
            }
        }
        if (isSame()) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
        
        br.close();
    }
    
    private static void convert(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                a[i][j] = 1 -a[i][j];
            }
        }
    }
    
    private static boolean isSame() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}