class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }

        java.util.Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        int start = 0;

        for (int i = 0; i < n; i++) {
            if (i == n - 1 || sorted[i + 1][0] - sorted[i][0] > limit) {
                int groupSize = i - start + 1;
                int[] indices = new int[groupSize];

                for (int j = 0; j < groupSize; j++) {
                    indices[j] = sorted[start + j][1];
                }

                java.util.Arrays.sort(indices);

                for (int j = 0; j < groupSize; j++) {
                    result[indices[j]] = sorted[start + j][0];
                }

                start = i + 1;
            }
        }

        return result;
    }
}