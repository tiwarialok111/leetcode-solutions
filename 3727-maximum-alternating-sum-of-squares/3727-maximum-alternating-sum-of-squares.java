class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squared = new long[n];
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            squared[i] = val * val;
        }
        java.util.Arrays.sort(squared);
        long total = 0;
        int half = n / 2;
        for (int i = 0; i < half; i++) {
            total -= squared[i];
        }
        for (int i = half; i < n; i++) {
            total += squared[i];
        }
        return total;
    }
}