import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static String command;
    static int number;
    static Deque<Integer> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            if (st.countTokens() == 2) {
                command = st.nextToken();
                number = Integer.parseInt(st.nextToken());
            } else {
                command = st.nextToken();
            }
            
            push(command, number);
            front(command);
            back(command);
            size(command);
            empty(command);
            pop(command);
        }
        
        System.out.println(sb);
        
        br.close();
    }
    
    private static void push(String command, int number) {
        if ("push".equals(command)) {
            deque.add(number);
        }
    }
    
    private static void front(String command) {
        if ("front".equals(command)) {
            if (isEmpty()) {
                sb.append("-1").append("\n");
            } else {
                sb.append(String.valueOf(deque.peek())).append("\n");
            }
        }
    }
    
    private static void back(String command) {
        if ("back".equals(command)) {
            if (isEmpty()) {
                sb.append("-1").append("\n");
            } else {
                sb.append(String.valueOf(deque.peekLast())).append("\n");
            }
        }
    }
    
    private static void size(String command) {
        if ("size".equals(command)) {
            sb.append(String.valueOf(deque.size())).append("\n");
        }
    }
    
    private static void empty(String command) {
        if ("empty".equals(command)) {
            if (isEmpty()) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
    }
    
    private static void pop(String command) {
        if ("pop".equals(command)) {
            if (isEmpty()) {
                sb.append("-1").append("\n");
            } else {
                sb.append(String.valueOf(deque.poll())).append("\n");
            }
        }
    }
    
    private static boolean isEmpty() {
        return deque.isEmpty();
    }
}