import java.io.*;
import java.util.*;

public class Main{
	public static int N;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();	
	public static Queue<Integer> result = new LinkedList<Integer>();	
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
        N = Integer.parseInt(br.readLine());
		
        for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
            
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
            
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
        
		st = new StringTokenizer(br.readLine());	
        int size = st.countTokens();
		for (int i = 0; i < size; i++) 
			result.add(Integer.parseInt(st.nextToken()));
		
		int first = result.poll();
		if (first != 1)	
			sb.append("0");
		else {
			if(bfs(1))	
				sb.append("1");	
			else
				sb.append("0");	
		}
        System.out.println(sb);
		br.close();
	}

	static boolean bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> temp = new HashSet<>();
		boolean[] visited = new boolean[N + 1];	
        
		visited[start] = true;
		queue.add(start);
        
		while (!queue.isEmpty()) {
			int now = queue.poll();
            
			for (int next : graph.get(now)) {
				if (!visited[next]) {
					temp.add(next);
					visited[next] = true;
				}
			}
            
			int size = temp.size();
			if (!result.isEmpty()) {
				for (int i = 0; i < size; i++) {
					int num = result.poll();
					if (temp.contains(num))
						queue.add(num);
					else	
						return false;
				}
			}
			temp.clear();
		}
		return true;
	}
}