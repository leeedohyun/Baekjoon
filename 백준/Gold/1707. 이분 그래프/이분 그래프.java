import java.io.*;
import java.util.*;

public class Main {
	static int[] color;
	static ArrayList<ArrayList<Integer>> graph;
	static int V,E;
	static int from, to;
	static String answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
		    answer = "YES";
		    StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			
			for (int j = 0; j < V; j++) {
				graph.add(new ArrayList<>());
			}
			
			for (int j = 0; j < E; j++) {
			    st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken()) - 1;
				to = Integer.parseInt(st.nextToken()) - 1;
				
				graph.get(from).add(to);
				graph.get(to).add(from);
			}
			
			color = new int[V];
			for (int j = 0; j < V; j++) {
				if(color[j] == 0) {
					if(!bfs(j)) {
				        break;
					}
				}
			}
			System.out.println(answer);
		}
	}

	public static boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		color[n] = 1;
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(Integer i : graph.get(current)) {
				if(color[current] == color[i]) {
				    answer = "NO";
					return false;
				}
				if(color[i] == 0) {
					color[i] = color[current] * (-1);
					q.add(i);
				}
			}
		}
		return true;
	}
}