class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
         List<MappedNumber> mappedNumbers = new ArrayList<>();
        
        for (int num : nums) {
            mappedNumbers.add(new MappedNumber(num, mapNumber(num, mapping)));
        }

        Collections.sort(mappedNumbers, (a, b) -> {
            if (a.mapped != b.mapped) {
                return Long.compare(a.mapped, b.mapped);
            } else {
                return Integer.compare(a.index, b.index); 
            }
        });

        
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = mappedNumbers.get(i).original;
        }

        return sortedNums;
    }

  
    private long mapNumber(int num, int[] mapping) {
        StringBuilder mappedNum = new StringBuilder();
        String numStr = String.valueOf(num);
        for (char digit : numStr.toCharArray()) {
            mappedNum.append(mapping[digit - '0']);
        }
        return Long.parseLong(mappedNum.toString());
    }


}

   
    class MappedNumber {
        int original;
        long mapped;
        int index;

        MappedNumber(int original, long mapped, int index) {
            this.original = original;
            this.mapped = mapped;
            this.index = index;
        }

        MappedNumber(int original, long mapped) {
            this.original = original;
            this.mapped = mapped;
            this.index = -1;  
        }
   
    }
