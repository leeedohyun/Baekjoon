import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        char[] colors = new char[n];
        
        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            colors[i] = line.charAt(i);
        }
        
        int countB = 0;
        int countR = 0;
        char prev = '\0';
        for (int i = 0; i < n; i++) {
            if (prev != colors[i]) {
                if (colors[i] == 'R') {
                    countB += 1;
                } else {
                    countR += 1;
                }
            }
            prev = colors[i];
        }
        
        System.out.println(Math.min(countB, countR) + 1);
        
        br.close();
    }
}