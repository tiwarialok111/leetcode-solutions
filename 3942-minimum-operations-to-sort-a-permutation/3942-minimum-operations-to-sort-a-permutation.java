
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Check whether nums is a cyclic ascending sequence
        boolean ascending = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (nums[0] + i) % n) {
                ascending = false;
                break;
            }
        }

        if (ascending) {
            int k = nums[0];
            int rotate = (n - k) % n;

            return Math.min(rotate, n - rotate + 2);
        }

        // Check whether nums is a cyclic descending sequence
        boolean descending = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (nums[0] - i + n) % n) {
                descending = false;
                break;
            }
        }

        if (descending) {
            int k = (n - 1 - nums[0] + n) % n;
            return 1 + Math.min(k, n - k);
        }

        return -1;
    }
}
