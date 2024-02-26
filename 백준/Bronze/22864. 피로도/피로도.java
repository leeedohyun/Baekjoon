import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int work = 0;
        int fatigue = 0;
        for (int i = 0; i < 24; i++) {
            if (fatigue + a <= m) {
                fatigue += a;
                work += b;
            } else {
                fatigue -= c;
            }
            if (fatigue < 0) {
                fatigue = 0;
            }
        }
        System.out.println(work);
        
        br.close();
    }
}