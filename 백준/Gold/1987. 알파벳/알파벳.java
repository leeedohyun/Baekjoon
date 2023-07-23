import java.io.*;
import java.util.*;

public class Main {
	public static int r, c;
	public static int[][] board;
	public static boolean[] checked = new boolean[26];
	public static int max = 0;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new int[r][c];
        
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = line.charAt(j) - 'A';
			}
		}
		dfs(0, 0, 0);
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int cnt) {
		if (checked[board[x][y]]) {
			max = Math.max(max, cnt);
			return;
		}
		else {
			checked[board[x][y]] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
			
				if(nx < 0 || ny < 0 || nx >= r || ny >= c) 
                    continue;
                
				dfs(nx, ny, cnt + 1);
			}
			checked[board[x][y]] = false;
		}
	}
}