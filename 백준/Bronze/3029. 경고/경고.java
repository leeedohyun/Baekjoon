import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String startTime[] = br.readLine().split(":");
        String endTime[] = br.readLine().split(":");
        
        int gap[] = new int[3];
        
        for (int i = 0; i < 3; i++) {
            gap[i] = Integer.parseInt(endTime[i]) - Integer.parseInt(startTime[i]);
        }
        
        if (gap[2] < 0) {
            gap[2] += 60;
            gap[1]--;
        }
        if (gap[1] < 0) {
            gap[1] += 60;
            gap[0]--;
        }
        if (gap[0] < 0) {
            gap[0] += 24;
        }
        
        if (gap[0] == 0 && gap[1] == 0 && gap[2] == 0) {
            gap[0] = 24;
        }
        
        System.out.format("%02d:%02d:%02d", gap[0], gap[1], gap[2]);
    }
}