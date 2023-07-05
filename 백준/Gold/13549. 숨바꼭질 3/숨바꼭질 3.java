import java.io. * ;
import java.util. * ;

public class Main {
    public static int n, k;
    public static Queue<Location> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
    }

    public static void bfs(int number) {
        if (number >= k) {
            System.out.println(number - k);
            return;
        }

        int[] time = new int[100001];
        q.add(new Location(number, 0));
        time[number] = 1;

        while (!q.isEmpty()) {
            Location location = q.poll();
            
            int minus = location.x - 1;
            int plus = location.x + 1;
            int multiple = location.x * 2;
            
            if (multiple == k) {
            	System.out.println(location.time);
                return;
            }
            else if (minus == k || plus == k) {
                System.out.println(location.time + 1);
                return;
            }
            if (location.x < k && multiple <= 100000 && (time[multiple] == 0 || time[multiple] > time[location.x])) {
                q.add(new Location(multiple, location.time));
                time[multiple] = time[location.x];
            }
            if (minus >= 0 && (time[minus] == 0 || time[minus] > time[location.x] + 1) ) {
                q.add(new Location(minus, location.time + 1));
                time[minus] = time[location.x] + 1;
            }
            if (location.x < k &&  plus <= 100000 && (time[plus] == 0 || time[plus] > time[location.x] + 1)) {
                q.add(new Location(plus, location.time + 1));
                time[plus] = time[location.x] + 1;
            }
        }
    }
    
    static class Location{
        int x;
        int time;

        public Location(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}