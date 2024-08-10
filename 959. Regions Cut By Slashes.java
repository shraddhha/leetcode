class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 3 * n;
        int[][] graph = new int[size][size];
      
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    graph[i * 3][j * 3 + 2] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    graph[i * 3][j * 3] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        
        int regions = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (graph[i][j] == 0) {
                    dfs(graph, i, j);
                    regions++;
                }
            }
        }
        
        return regions;
    }
    
    private void dfs(int[][] graph, int x, int y) {
        int n = graph.length;
        if (x < 0 || x >= n || y < 0 || y >= n || graph[x][y] == 1) {
            return;
        }
        graph[x][y] = 1;
        dfs(graph, x - 1, y);
        dfs(graph, x + 1, y);
        dfs(graph, x, y - 1);
        dfs(graph, x, y + 1);
    
    }
}
