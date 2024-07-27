class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26; 
        long inf = (long) 1e12; 
        
        long[][] minCost = new long[n][n];
        for (long[] row : minCost) {
            Arrays.fill(row, inf);
        }
        
 
        for (int i = 0; i < n; i++) {
            minCost[i][i] = 0;
        }
  
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            minCost[u][v] = Math.min(minCost[u][v], cost[i]);
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (minCost[i][k] < inf && minCost[k][j] < inf) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }
        
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int srcChar = source.charAt(i) - 'a';
            int tgtChar = target.charAt(i) - 'a';
            if (minCost[srcChar][tgtChar] == inf) {
                return -1; 
            }
            totalCost += minCost[srcChar][tgtChar];
        }
        
        return totalCost;
    }

        
}
