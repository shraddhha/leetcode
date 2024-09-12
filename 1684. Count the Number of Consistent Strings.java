class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }
        
        // Step 2: Initialize count for consistent strings
        int consistentCount = 0;
        
        // Step 3: Check each word
        for (String word : words) {
            boolean isConsistent = true;
            
            // Step 4: Check if all characters in word are in allowedSet
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            
            // Step 5: If the word is consistent, increment the count
            if (isConsistent) {
                consistentCount++;
            }
        }
        
        // Step 6: Return the total count of consistent strings
        return consistentCount;
    
    }
}
