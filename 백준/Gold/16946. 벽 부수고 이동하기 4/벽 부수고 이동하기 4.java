import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
	public static int[][] map, group;
	public static Map<Integer,Integer> groupSize = new HashMap<>();
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		group = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j]= Character.getNumericValue(line.charAt(j));
			}
		}
		
		int groupCnt=1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && group[i][j] == 0) {
					groupSize.put(groupCnt, bfs(i, j, groupCnt));
					groupCnt++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (group[i][j] == 0) {
					sb.append(count(i, j) + "");
					continue;
				}
				sb.append(0 + "");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static int count(int x, int y) {
	    int cnt = 1;
	    
		if(map[x][y] == 0) 
		    return 0;
		    
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= n || ny >= m || group[nx][ny] == 0)
				continue;
				
			set.add(group[nx][ny]);
		}
		
		for (int size : set) {
			cnt += groupSize.get(size);
		}
		
		return cnt % 10;
	}

	public static int bfs(int x, int y, int groupCnt) {
		int cnt = 1;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		
		group[x][y] = groupCnt;
		
		while (!q.isEmpty()) {
			Point now = q.poll(); 
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if (nx < 0 || ny <0 || nx >= n || ny >= m)
					continue;
					
				if (group[nx][ny] == 0 && map[nx][ny] == 0) {
					group[nx][ny] = groupCnt;
					cnt++;
					q.add(new Point(nx, ny));
				}
			}
		}
		return cnt;
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}