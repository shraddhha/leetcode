class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        
        // Traverse through each word and check the circular condition
        for (int i = 0; i < words.length; i++) {
            // Get the last character of the current word
            char lastChar = words[i].charAt(words[i].length() - 1);
      
            char firstChar = words[(i + 1) % words.length].charAt(0);
            

            if (lastChar != firstChar) {
                return false;
            }
        }
        
       
        return true;
    
        
    }
}
