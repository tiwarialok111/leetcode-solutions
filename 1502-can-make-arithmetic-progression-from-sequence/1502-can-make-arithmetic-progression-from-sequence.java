class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int n = arr.length;
        if ((max - min) % (n - 1) != 0) {
            return false;
        }

        int diff = (max - min) / (n - 1);
        if (diff == 0) {
            return true;
        }

        boolean[] seen = new boolean[n];
        for (int num : arr) {
            if ((num - min) % diff != 0) {
                return false;
            }
            int index = (num - min) / diff;
            if (seen[index]) {
                return false;
            }
            seen[index] = true;
        }

        return true;
    }
}