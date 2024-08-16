class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
         int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);

            int firstElement = currentArray.get(0);
            int lastElement = currentArray.get(currentArray.size() - 1);

            // Calculate the maximum distance by considering current array with previous min and max
            maxDistance = Math.max(maxDistance, Math.abs(lastElement - minVal));
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - firstElement));

            // Update the global min and max
            minVal = Math.min(minVal, firstElement);
            maxVal = Math.max(maxVal, lastElement);
        }

        return maxDistance;
    
        
    }
}
