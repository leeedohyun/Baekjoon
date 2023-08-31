import java.io.*;
import java.util.*;

public class Main {
    public static long s, t;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        s = Long.parseLong(st.nextToken());
        t = Long.parseLong(st.nextToken());
        
        if (s == t) {
            System.out.println("0");
        } else {
            System.out.println(bfs());
        }
    }
    
    public static String bfs() {
        Queue<Point> q = new LinkedList<>();
        HashSet<Long> set = new HashSet<>();
        
        q.add(new Point(s, ""));
        
        while (!q.isEmpty()) {
            Point now = q.poll();
            
            if (now.s == t)
                return now.result;
            
            if (!set.contains(now.s * now.s)) {
                set.add(now.s * now.s);
                q.add(new Point(now.s * now.s, now.result + "*"));
            }
            if (!set.contains(now.s + now.s)) {
                set.add(now.s + now.s);
                q.add(new Point(now.s + now.s, now.result + "+"));
            }
            if (!set.contains(0L)) {
                set.add(0L);
                q.add(new Point(0L, now.result + "-"));
            }
            if (now.s != 0 && !set.contains(now.s / now.s)) {
                set.add(now.s / now.s);
                q.add(new Point(now.s / now.s, now.result + "/"));
            }
        }
        return "-1";
    }
    
    public static class Point {
        long s;
        String result;
        
        public Point(long s, String result) {
            this.s = s;
            this.result = result;
        }
    }
}