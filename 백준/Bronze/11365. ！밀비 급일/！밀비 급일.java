import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String line = br.readLine();
            
            if (line.equals("END")) 
                break;
                
            StringBuffer buffer = new StringBuffer(line);
            String result = buffer.reverse().toString();
            
            sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
}