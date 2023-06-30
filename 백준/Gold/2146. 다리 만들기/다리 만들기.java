import java.util.*;
import java.io.*;

public class Main {
	static class Island {
		int x;
        int y;
        
		Island(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    
	public static int N;
	public static int[][] map;
	public static int[][] distance;
	public static boolean[][] visit;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	public static int number;
	public static Queue<Island> queue;
	public static int answer;
    
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
        
		number = 1;
        map = new int[N][N];
        distance = new int[N][N];
        visit = new boolean[N][N];
		queue = new LinkedList<Island>();
        
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					queue.add(new Island(i, j));
					visit[i][j] = true;
					map[i][j] = number;
					countIsland();
					number++;
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		queue = new LinkedList<Island>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					queue.add(new Island(i, j));
				}
			}
		}
		bfs();
		System.out.println(answer);
	}
	
	public static void bfs() {
		while (!queue.isEmpty()) {
			Island island = queue.poll();
            
			for (int i = 0; i < 4; i++) {
				int nx = island.x + dx[i];
				int ny = island.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
					
				if (map[nx][ny] != 0 && map[nx][ny] != map[island.x][island.y])
					answer = Math.min(answer, distance[nx][ny] + distance[island.x][island.y]);
					
				if (map[nx][ny] == 0) {
					queue.add(new Island(nx, ny));
					map[nx][ny] = map[island.x][island.y];
					distance[nx][ny] = distance[island.x][island.y] + 1;
				}
			}
		}
	}
	
	public static void countIsland() {
		while (!queue.isEmpty()) {
			Island island = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = island.x + dx[i];
				int ny = island.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
			    
				if (!visit[nx][ny] && map[nx][ny] == 1) {
					map[nx][ny] = number;
					visit[nx][ny] = true;
					queue.add(new Island(nx,ny));
				}
			}
		}
	}
}
