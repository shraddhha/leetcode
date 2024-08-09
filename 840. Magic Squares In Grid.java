class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        // Iterate over all possible 3x3 subgrids
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isMagicSquare(int[][] grid, int row, int col) {
        // The center of a 3x3 magic square must be 5
        if (grid[row + 1][col + 1] != 5) return false;
        
        // Extract all elements of the 3x3 subgrid
        int[] s = new int[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s[index++] = grid[row + i][col + j];
            }
        }
        
        // Check if all elements are distinct and between 1 to 9
        boolean[] seen = new boolean[10];
        for (int num : s) {
            if (num < 1 || num > 9 || seen[num]) return false;
            seen[num] = true;
        }
        
        // Check rows, columns, and diagonals
        return (s[0] + s[1] + s[2] == 15 && // row 1
                s[3] + s[4] + s[5] == 15 && // row 2
                s[6] + s[7] + s[8] == 15 && // row 3
                s[0] + s[3] + s[6] == 15 && // col 1
                s[1] + s[4] + s[7] == 15 && // col 2
                s[2] + s[5] + s[8] == 15 && // col 3
                s[0] + s[4] + s[8] == 15 && // diagonal 1
                s[2] + s[4] + s[6] == 15);  // diagonal 2
    
        
    }
}
