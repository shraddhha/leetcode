class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Get the minimum of the current row sum and column sum
                int minValue = Math.min(rowSum[i], colSum[j]);
                // Assign this value to the matrix cell
                matrix[i][j] = minValue;
                // Subtract the assigned value from the row sum and column sum
                rowSum[i] -= minValue;
                colSum[j] -= minValue;
            }
        }
        return matrix;
    
        
    }
}
