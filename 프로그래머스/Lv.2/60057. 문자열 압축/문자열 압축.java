class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String prev = s.substring(0, i);
            String compressed = "";
            int count = 1;
            
            for (int j = i; j < s.length(); j += i) {
                String sub = "";
                
                for (int k = j; k < j + i; k++) {
                    if (k < s.length()) {
                        sub += s.charAt(k);
                    }
                }
                
                if (prev.equals(sub)) {
                    count++;
                } else {
                    if (count >= 2) {
                        compressed += count + prev;
                    } else {
                        compressed += prev;
                    }
                    
                    sub = "";
                    for (int k = j; k < j + i; k++) {
                        if (k < s.length()) {
                            sub += s.charAt(k);
                        }
                    }
                    prev = sub;
                    count = 1;
                }
            }
            if (count >= 2) {
                compressed += count + prev;
            } else {
                compressed += prev;
            }
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }       
}