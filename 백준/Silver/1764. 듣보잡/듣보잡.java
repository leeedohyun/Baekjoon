import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }
        
        List<String> names = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String unseePerson = br.readLine();
            map.put(unseePerson, map.getOrDefault(unseePerson, 0) + 1);
            if (map.get(unseePerson) == 2) {
                names.add(unseePerson);
            }
        }
        
        Collections.sort(names);
        
        System.out.println(names.size());
        for (String name : names) {
            System.out.println(name);
        }
        
        br.close();
    }
}