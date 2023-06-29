import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static int index = 1;
    public static boolean flag = true;
    public static List<List<Integer>> data = new ArrayList<>();
    public static boolean[] check;
    public static int[] answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            data.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            data.get(from).add(to);
            data.get(to).add(from);
        }
        
         st = new StringTokenizer(br.readLine());
         answer = new int[n];
         for (int i = 0; i < n; i++) {
             answer[i] = Integer.parseInt(st.nextToken());
         }
         
         if (answer[0] != 1) {
             System.out.println(0);
             return;
         }
    
        dfs(1);
        if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
    }
    
    public static void dfs(int x) {
        if (check[x])
            return;
            
        check[x] = true;
        HashSet<Integer> set = new HashSet<>();
		for(int next : data.get(x)) {
			if(check[next]) 
			    continue;
			set.add(next);
		}
		
		if(set.isEmpty()) 
		    return;
		
		if(set.contains(answer[index])) {
			dfs(answer[index++]);
		} else {
			flag = false;
		}
    }
}