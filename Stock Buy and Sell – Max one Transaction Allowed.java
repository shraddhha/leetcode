class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int minPrice = Integer.MAX_VALUE; // Minimum price seen so far
        int maxProfit = 0;               // Maximum profit possible

        // Traverse through the prices array
        for (int price : prices) {
            // Update the minimum price if the current price is lower
            if (price < minPrice) {
                minPrice = price;
            } else {
               
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    
    }
}
