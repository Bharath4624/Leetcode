import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color, -1);
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(graph, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfsCheck(int[][] graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
