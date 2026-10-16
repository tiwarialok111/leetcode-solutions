class Solution {
    private static final int MOD = 1_000_000_007;

    static class Node {
        long sum;
        long lazy;
    }

    private Node[] tree;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node();
        }

        java.util.HashMap<Integer, Integer> lastSeen = new java.util.HashMap<>();
        
        long currentSumOfDistinctCounts = 0;
        long totalSumOfSquares = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = lastSeen.getOrDefault(x, -1);
            
            int l = prev + 1 + 1;
            int r = i + 1;

            long rangeSum = query(1, 1, n, l, r);
            long delta = (2 * rangeSum + (r - l + 1)) % MOD;
            currentSumOfDistinctCounts = (currentSumOfDistinctCounts + delta) % MOD;

            updateRange(1, 1, n, l, r, 1);

            totalSumOfSquares = (totalSumOfSquares + currentSumOfDistinctCounts) % MOD;
            lastSeen.put(x, i);
        }

        return (int) totalSumOfSquares;
    }

    private void pushDown(int node, int start, int end) {
        if (tree[node].lazy != 0) {
            int mid = (start + end) / 2;
            apply(2 * node, start, mid, tree[node].lazy);
            apply(2 * node + 1, mid + 1, end, tree[node].lazy);
            tree[node].lazy = 0;
        }
    }

    private void apply(int node, int start, int end, long val) {
        tree[node].sum = (tree[node].sum + val * (end - start + 1)) % MOD;
        tree[node].lazy = (tree[node].lazy + val) % MOD;
    }

    private void updateRange(int node, int start, int end, int l, int r, long val) {
        if (l > end || r < start) {
            return;
        }
        if (l <= start && end <= r) {
            apply(node, start, end, val);
            return;
        }
        pushDown(node, start, end);
        int mid = (start + end) / 2;
        updateRange(2 * node, start, mid, l, r, val);
        updateRange(2 * node + 1, mid + 1, end, l, r, val);
        tree[node].sum = (tree[node].sum + MOD) % MOD;
        tree[node].sum = (tree[2 * node].sum + tree[2 * node + 1].sum) % MOD;
    }

    private long query(int node, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node].sum;
        }
        pushDown(node, start, end);
        int mid = (start + end) / 2;
        long p1 = query(2 * node, start, mid, l, r);
        long p2 = query(2 * node + 1, mid + 1, end, l, r);
        return (p1 + p2) % MOD;
    }
}