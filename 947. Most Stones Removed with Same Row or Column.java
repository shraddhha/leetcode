class Solution {
    public int numOfIslands = 0;
    public int removeStones(int[][] stones) {
         int[] parent = new int[20003]; // Union-Find data structure to represent parent relationships
        // Iterate over each stone and connect rows and columns
        for (int[] stone : stones) {
            unionSets(stone[0] + 1, stone[1] + 10002, parent);
        }
        // The result is the total number of stones minus the number of connected components
        return stones.length - numOfIslands;
    }

    public void unionSets(int a, int b, int[] parent) {
        int parA = findParent(a, parent); 
        int parB = findParent(b, parent); 
      
        if (parA != parB) {
            parent[parB] = parA; // Connect the components
            numOfIslands--; // Since two separate components are now one, decrement the count
        }
    }

    public int findParent(int node, int[] parent) {
        // If this node is being visited for the first time, set its parent to itself and increase island count
        if (parent[node] == 0) {
            parent[node] = node; // Initialize the parent of 'node' to be itself
            numOfIslands++; // New island found, increment count
        }
       
        if (parent[node] == node) {
            return node;
        }
        // Recursively find the parent, applying path compression along the way
        int par = findParent(parent[node], parent);
        parent[node] = par; // Path compression step
        return par; 
 
        
    }
}
