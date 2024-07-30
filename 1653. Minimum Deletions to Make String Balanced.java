class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int minDeletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else {
             
                minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }

        return minDeletions;
    
        
    }
}
