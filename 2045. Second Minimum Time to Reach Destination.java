class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Priority queue to store (time, node, count)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 1, 0});  // time, node, count of reaching this node

        // Distances to store the first and second minimum times to reach each node
        int[][] dist = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int node = curr[1];
            int count = curr[2];

            for (int neighbor : graph.get(node)) {
                int waitTime = 0;
                int cycleTime = currTime / change;
                if (cycleTime % 2 == 1) {  // Red light
                    waitTime = change - (currTime % change);
                }
                int newTime = currTime + waitTime + time;

                if (newTime < dist[neighbor][0]) {
                    dist[neighbor][1] = dist[neighbor][0];
                    dist[neighbor][0] = newTime;
                    pq.offer(new int[]{newTime, neighbor, count + 1});
                } else if (newTime > dist[neighbor][0] && newTime < dist[neighbor][1]) {
                    dist[neighbor][1] = newTime;
                    pq.offer(new int[]{newTime, neighbor, count + 1});
                }
            }
        }

        return dist[n][1];
    }

    
        
    
}
