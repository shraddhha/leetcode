class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int left =0;
        int right = nums[nums.length-1]-nums[0];
        int mid=0;
        while(left<right)
        {
            mid= (left+right)/2;
            if(pairs(nums,k,mid))
            {
                right= mid;
            }
            else
            {
                left= mid+1;
            }
        }
        return left;
    }
    public boolean pairs(int[] nums,int k,int mid)
    {
        int left =0;
        int count=0;
        for(int right=1;right<nums.length;right++)
        {
            while(nums[right]-nums[left]>mid)
            {
                left++;
                
            }
            count += right - left;
        }
        return (count >= k);
    
        
    }
}
