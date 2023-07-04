import java.io.*;
import java.util.*;

public class Main {
    public static boolean visited[][] = new boolean[1001][1001];
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int s = Integer.parseInt(br.readLine());
		
		bfs(s);

	}

	public static void bfs(int end) {
		Queue<Emoticon> q = new LinkedList<>();
		q.add(new Emoticon(0, 1, 0));
		visited[0][1] = true;
		
		while(!q.isEmpty()) {
			Emoticon now = q.poll();
			
			if(now.screen == end) {
				System.out.println(now.time);
				return;
			}
			
			// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
			q.add(new Emoticon(now.screen, now.screen, now.time + 1));
			
			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
			if(now.clipBoard != 0 && now.screen + now.clipBoard <= end &&  !visited[now.clipBoard][now.screen + now.clipBoard]) {
				q.add(new Emoticon(now.clipBoard, now.screen+now.clipBoard, now.time + 1));
				visited[now.clipBoard][now.screen + now.clipBoard] = true;
			}
			
			// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
			if(1 <= now.screen && !visited[now.clipBoard][now.screen - 1]) {
				q.add(new Emoticon(now.clipBoard, now.screen - 1, now.time + 1));
				visited[now.clipBoard][now.screen - 1] = true;
			}
		}
		
	}
}

class Emoticon {
	int clipBoard;
	int screen;
	int time;
	
	Emoticon(int clipBoard, int screen, int time){
		this.clipBoard = clipBoard;
		this.screen = screen;
		this.time = time;
	}
}