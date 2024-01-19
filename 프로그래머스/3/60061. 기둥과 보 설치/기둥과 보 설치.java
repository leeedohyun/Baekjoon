import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            
            if (b == 0) {
                int index = 0;
                for (int j = 0; j < answer.size(); j++) {
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && a == answer.get(j).get(2)) {
                        index = j;
                    }
                }
                ArrayList<Integer> erased = answer.get(index);
                answer.remove(index);
                if (!possible(answer)) {
                    answer.add(erased);
                }
            }
            if (b == 1) {
                ArrayList<Integer> inserted = new ArrayList<Integer>();
                inserted.add(x);
                inserted.add(y);
                inserted.add(a);
                answer.add(inserted);
                
                if (!possible(answer)) {
                    answer.remove(answer.size() - 1);
                }
            }
        }
        
        ArrayList<Node> sorted = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            sorted.add(new Node(answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2)));
        }
        Collections.sort(sorted);
        
        int[][] result = new int[sorted.size()][3];
        for (int i = 0; i < sorted.size(); i++) {
            result[i][0] = sorted.get(i).getX();
            result[i][1] = sorted.get(i).getY();
            result[i][2] = sorted.get(i).getStuff();
        }
        return result;
    }
    
    private static boolean possible(ArrayList<ArrayList<Integer>> answer) {
        for (int i = 0; i < answer.size(); i++) {
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int stuff = answer.get(i).get(2);
            
            if (stuff == 0) {
                boolean check = false;
                if (y == 0) {
                    check = true;
                }
                for (int j = 0; j < answer.size(); j++) {
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && answer.get(j).get(2) == 1) {
                        check = true;
                    }
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && answer.get(j).get(2) == 1) {
                        check = true;
                    }
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && answer.get(j).get(2) == 0) {
                        check = true;
                    }
                }
                if (!check) {
                    return false;
                }
            } else if (stuff == 1) {
                boolean check = false;
                boolean left = false;
                boolean right = false;
                for (int j = 0; j < answer.size(); j++) {
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        left = true;
                    }
                    if (x + 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        right = true;
                    }
                }
                if (left && right) {
                    check = true;
                }
                if (!check) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static class Node implements Comparable<Node> {
        private int x;
        private int y;
        private int stuff;
        
        public Node(int x, int y, int stuff) {
            this.x = x;
            this.y = y;
            this.stuff = stuff;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public int getStuff() {
            return stuff;
        }
        
        @Override
        public int compareTo(Node other) {
            if (this.x == other.x && this.y == other.y) {
                return Integer.compare(this.stuff, other.stuff);
            }
            if (this.x == other.x) {
                return Integer.compare(this.y, other.y);
            }
            return Integer.compare(this.x, other.x);
        }
    }
}