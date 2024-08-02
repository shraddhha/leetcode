class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        int totalOnes = 0;
        for (int num : nums) {
            if (num == 1) totalOnes++;
        }
        
        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }
        
        int[] extendedNums = new int[2 * n];
        for (int i = 0; i < n; i++) {
            extendedNums[i] = nums[i];
            extendedNums[i + n] = nums[i];
        }
      
        int maxOnesInWindow = 0, currentOnesInWindow = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (extendedNums[i] == 1) currentOnesInWindow++;
        }
        maxOnesInWindow = currentOnesInWindow;
        
        for (int i = totalOnes; i < 2 * n; i++) {
            if (extendedNums[i] == 1) currentOnesInWindow++;
            if (extendedNums[i - totalOnes] == 1) currentOnesInWindow--;
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
        }
      
        return totalOnes - maxOnesInWindow;
    
        
    }
}
