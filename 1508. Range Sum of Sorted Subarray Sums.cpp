class Solution {
    const int mod = 1e9+7;
public:
    int rangeSum(vector<int>& nums, int n, int l, int r) {
        
        vector<int> arr;
        
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum = (sum + nums[j]) % mod;
                arr.push_back(sum);
            }
        }
        
    
        sort(arr.begin(), arr.end());
        
       
        int sum = 0;
        for(int i = l - 1; i < r; i++) {
            sum = (sum + arr[i]) % mod;
        }
        
        return sum;
    }
};
        
