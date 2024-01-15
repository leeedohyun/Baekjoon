class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int lockLength = lock.length;
        int keyLength = key.length;
    
        int[][] expanded = new int[lockLength * 3][lockLength * 3];
        
        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                expanded[i + lockLength][j + lockLength] = lock[i][j]; 
            }
        }
        
        for (int k = 0; k < 4; k++) {
            key = rotate(key);
            
            for (int x = 0; x < lockLength * 2; x++) {
                for (int y = 0; y < lockLength * 2; y++) {
                    for (int i = 0; i < keyLength; i++) {
                        for (int j = 0; j < keyLength; j++) {
                            expanded[x + i][y + j] += key[i][j];
                        }
                    }
                    if (check(expanded)) {
                        return true;
                    }
                    
                    for (int i = 0; i < keyLength; i++) {
                        for (int j = 0; j < keyLength; j++) {
                            expanded[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private int[][] rotate(int[][] key) {
        int keyLength = key.length;
        int[][] rotatedKey = new int[keyLength][keyLength];
        
        for (int i = 0; i < keyLength; i++) {
            for (int j = 0; j < keyLength; j++) {
                rotatedKey[j][keyLength - i - 1] = key[i][j];
            }
        }
        return rotatedKey;
    }
    
    public static boolean check(int[][] newLock) {
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}