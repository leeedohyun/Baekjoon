import java.io.*;
import java.util.*;

class Main {
    public static Node[] tree;
    public static int[] min, max;
    public static int nodeIndex = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1];
        min = new int[n + 1];
        max = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            tree[i] = new Node(i, -1, -1);
            min[i] = n;
            max[i] = 0;
        }
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int data = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            tree[data].left = left;
            tree[data].right = right;
            
            if (left != -1)
                tree[left].parent = data;
            if (right != -1)
                tree[right].parent = data;
        }
        
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (tree[i].parent == -1) {
                root = i;
				break;
			}
		}
		
		inorder(root, 1);
		int level = 1;
		int width = 0;
		
		for (int i = 0; i <= n; i++) {
		    int tmp = max[i] - min[i];
		    if (width < tmp) {
		        level = i;
		        width = tmp;
		    }
		}
		System.out.println(level + " " + (width + 1));
    }
    
    public static void inorder(int root, int level) {
		Node now = tree[root];

		if (now.left != -1)
			inorder(now.left, level + 1);

		min[level] = Math.min(min[level], nodeIndex);
	    max[level] = Math.max(max[level], nodeIndex);
	    nodeIndex++;

	    if (now.right != -1)
	    	inorder(now.right,level + 1);
	}
    
    static class Node {
        int parent;
        int data;
        int left;
        int right;
        
        public Node(int data, int left, int rigth) {
            this.parent = -1;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}