import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int max = 0;
    public static int[][] board;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
      
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        brute(0);
        
        System.out.println(max);
    }
    
    public static void brute(int count) {
        if (count == 5) {
            findMax();
            return;
        }
        
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++)
            copy[i] = board[i].clone();
            
        for (int i = 0; i < 4; i++) {
            move(i);
            brute(count + 1);
            for (int j = 0; j < n; j++)
                board[j] = copy[j].clone();
        }
    }
    
    public static void move(int direction) {
        switch (direction) {
            case 0:
                for (int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    
                    for (int j = 0; j < n; j++) {
                        if (board[i][j] != 0) {
                            if (block == board[i][j]) {
                                board[i][index - 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            } else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
                
            case 1:
                for (int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    
                    for (int j = n - 1; j >= 0; j--) {
                        if (board[i][j] != 0) {
                            if (block == board[i][j]) {
                                board[i][index + 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            } else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
                
            case 2:
                for (int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    
                    for (int j = 0; j < n; j++) {
                        if (board[j][i] != 0) {
                            if (block == board[j][i]) {
                                board[index - 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            } else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
                
            case 3:
                for (int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    
                    for (int j = n - 1; j >= 0; j--) {
                        if (board[j][i] != 0) {
                            if (block == board[j][i]) {
                                board[index + 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            } else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
    
    public static void findMax() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
    }
}