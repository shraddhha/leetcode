class Solution {
    public int[] frequencySort(int[] nums) {
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

    
        Comparator<Integer> comparator = (a, b) -> {
            int freqCompare = Integer.compare(frequencyMap.get(a), frequencyMap.get(b));
            if (freqCompare != 0) {
                return freqCompare;  
            } else {
                return Integer.compare(b, a);  
            }
        };

        
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        Collections.sort(numsList, comparator);

     
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsList.get(i);
        }

        return nums;
    
        
    }
}
