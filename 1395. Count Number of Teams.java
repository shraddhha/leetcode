class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        
        for (int j = 0; j < n; j++) {
            int left_less = 0, right_greater = 0;
            int left_greater = 0, right_less = 0;
            
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    left_less++;
                } else if (rating[i] > rating[j]) {
                    left_greater++;
                }
            }
            
            for (int k = j + 1; k < n; k++) {
                if (rating[k] > rating[j]) {
                    right_greater++;
                } else if (rating[k] < rating[j]) {
                    right_less++;
                }
            }
            
            count += left_less * right_greater + left_greater * right_less;
        }
        
        return count;
    
        
    }
}
