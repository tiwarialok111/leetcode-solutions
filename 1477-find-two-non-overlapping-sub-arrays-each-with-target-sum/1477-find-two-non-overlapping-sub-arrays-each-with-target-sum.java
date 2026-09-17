class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLeft = new int[n];
        
        int currentSum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }

            if (currentSum == target) {
                int len = right - left + 1;
                if (left > 0 && minLeft[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minLeft[left - 1]);
                }
                minLen = Math.min(minLen, len);
            }

            minLeft[right] = minLen;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}