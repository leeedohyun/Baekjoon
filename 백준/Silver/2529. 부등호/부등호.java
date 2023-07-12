import java.io.*;
import java.util.*;

class Main {
    public static int n;
    public static String[] sign;
    public static boolean[] visited = new boolean[10];
    public static List<String> answer = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        sign = new String[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sign[i] = st.nextToken();
        }
        
        backtracking("", 0);
        
        System.out.print(answer.get(answer.size() - 1) + "\n");
		System.out.print(answer.get(0));
		
    }
    
    public static void backtracking(String number, int depth) {
        if (depth == n + 1) {
            answer.add(number);
            return;
        }
        
        for (int i = 0; i <= 9; i++) {
            if (visited[i])
                continue;
                
            if (depth == 0 || compare(Character.getNumericValue(number.charAt(depth - 1)), i, sign[depth - 1])) {
                visited[i] = true;
                backtracking(number + i, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private static boolean compare(int number1, int number2, String inequalitySign) {
        if (inequalitySign.equals("<")) {
            if (number1 > number2)
                return false;
        }
        if (inequalitySign.equals(">")) {
            if (number1 < number2)
                return false;
        }
        
        return true;
    }
}