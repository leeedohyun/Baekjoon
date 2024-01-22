import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        ArrayList<Stage> s = new ArrayList<>();
        int sum = stages.length;
        
        for (int stage = 1; stage <= N; stage++) {
            int stageNumber = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == stage) {
                    stageNumber += 1;
                }
            }
        
            double failure = 0;
            if (sum >= 1) {
                failure = (double) stageNumber / sum;
            }
            
            s.add(new Stage(stage,  failure));
            sum -= stageNumber;
        }
        
        Collections.sort(s);
        
        int[] answer = new int[N];
        
        for (int i = 0; i < N; i++) {
            answer[i] = s.get(i).getStage();
        }
        return answer;
    }
    
    static class Stage implements Comparable<Stage> {
        private int stage;
        private double failure;
        
        public Stage(int stage, double failure) {
            this.stage = stage;
            this.failure = failure;
        }
        
        public int getStage() {
            return stage;
        }
        
        @Override
        public int compareTo(Stage other) {
            return Double.compare(other.failure, this.failure);
        }
    }
}