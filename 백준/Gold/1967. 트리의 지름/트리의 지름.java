import java.io.*;
import java.util.*;

class Main {
    public static List<Node>[] tree;
    public static boolean[] visited;
    public static int max = 0;
    public static int farNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            tree[from].add(new Node(to, length));
            tree[to].add(new Node(from, length));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(farNode, 0);

        System.out.println(max);
        
        br.close();
    }

    public static void dfs(int x, int length) {
        if (length > max) {
            max = length;
            farNode = x;
        }
        visited[x] = true;

        for (int i = 0; i < tree[x].size(); i++) {
            Node now = tree[x].get(i);

            if (!visited[now.to]) {
                dfs(now.to, now.length + length);
                visited[now.to] = true;
            }
        }
    }

    static class Node {
        int to;
        int length;

        public Node(int to, int length) {
            this.to = to;
            this.length = length;
        }
    }
}