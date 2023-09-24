import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String board = br.readLine();
        
        for (int i = 0; i < board.length(); i++) {
            if (i + 3 < board.length() && isA(board, i)) {
                board = board.replaceFirst("XXXX", "AAAA");
                i += 3;
            } else if (i + 1 < board.length() && isB(board, i)) {
                board = board.replaceFirst("XX", "BB");
                i += 1;
            }
        }
        
        if (board.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(board);
        }
        
        br.close();
    }
    
    private static boolean isA(String board, int currentIndex) {
        for (int i = currentIndex; i < currentIndex + 4; i++) {
            if (board.charAt(i) != 'X')
                return false;
        }
        return true;
    }
    
    private static boolean isB(String board, int currentIndex) {
        for (int i = currentIndex; i < currentIndex + 2; i++) {
            if (board.charAt(i) != 'X')
                return false;
        }
        return true;
    }
}