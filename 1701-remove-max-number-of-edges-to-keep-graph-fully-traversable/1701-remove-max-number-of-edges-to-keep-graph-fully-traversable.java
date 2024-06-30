class Solution {

    class Graph {
        int[] parent;
        int[] rank;
        int components;
        public Graph(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n - 1;
            for (int i = 0;i < n;i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
    }

    public int findParent(int a, int[] parent) {
        while (a != parent[a]) {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }

    public boolean union(int a, int b, int[] parent, int[] rank) {
        int aParent = findParent(a, parent);
        int bParent = findParent(b, parent);
        if (aParent == bParent) {
            return false;
        }
        if (rank[aParent] > rank[bParent]) {
            parent[bParent] = aParent;
            rank[aParent] += rank[bParent];
        } else {
            parent[aParent] = bParent;
            rank[bParent] += rank[aParent];
        }
        return true;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Graph alice = new Graph(n + 1);
        Graph bob = new Graph(n + 1);
        boolean canAlice, canBob;
        int reqEdges = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                canAlice = union(edge[1], edge[2], alice.parent, alice.rank);
                canBob = union(edge[1], edge[2], bob.parent, bob.rank);
                if (canAlice || canBob) {
                    reqEdges++;
                }
                if (canAlice) {
                    alice.components--;
                }
                if (canBob) {
                    bob.components--;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                canAlice = union(edge[1], edge[2], alice.parent, alice.rank);
                if (canAlice) {
                    reqEdges++;
                    alice.components--;
                }
            } else if (edge[0] == 2) {
                canBob = union(edge[1], edge[2], bob.parent, bob.rank);
                if (canBob) {
                    reqEdges++;
                    bob.components--;
                }
            }
        }
        if (alice.components == 1 && bob.components == 1) {
            return edges.length - reqEdges;
        }
        return -1;
    }
}