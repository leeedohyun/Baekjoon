import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] timeTable = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] time = br.readLine().split(" ");
            timeTable[i][0] = Integer.parseInt(time[0]);
            timeTable[i][1] = Integer.parseInt(time[1]);
        }
        
        Arrays.sort(timeTable, (o1,o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));
        
        int count = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (timeTable[i][0] >= end) {
                count += 1;
                end = timeTable[i][1];
            }
        }
        System.out.println(count);
        
        br.close();
    }
}