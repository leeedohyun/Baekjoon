import java.io.*;
import java.util.*;

class Main {
    public static Map<String, Node> map = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            
            map.put(data, new Node(data, left, right));
        }
        
        preOrder(map.get("A"));
        sb.append("\n");
        inOrder(map.get("A"));
        sb.append("\n");
        postOrder(map.get("A"));
        
        System.out.println(sb);
        
        br.close();
    }
    
    public static void preOrder(Node node) {
        sb.append(node.data);
        if (!node.left.equals("."))
            preOrder(map.get(node.left));
        if (!node.right.equals("."))
            preOrder(map.get(node.right));
    }
    
    public static void inOrder(Node node) {
        if (!node.left.equals("."))
            inOrder(map.get(node.left));
        sb.append(node.data);
        if (!node.right.equals("."))
            inOrder(map.get(node.right));
    }
    
    public static void postOrder(Node node) {
        if (!node.left.equals("."))
            postOrder(map.get(node.left));
        if (!node.right.equals("."))
            postOrder(map.get(node.right));
        sb.append(node.data);
    }
    
    static class Node {
        String data;
        String left;
        String right;
        
        public Node(String data, String left, String right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}