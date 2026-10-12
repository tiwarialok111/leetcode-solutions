class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;
        int bestI = -1;
        int bestJ = -1;
        long maxProduct = Long.MIN_VALUE;

            for(int i = 0;i < n;i++){
                 for(int j = 0;j < n;j++){
                     if(i != j && nums[i]+ nums[j] == target && nums[i] > nums[j]){
                         long prod = (long) nums[i] * nums[j];
                         if (prod > maxProduct){
                             maxProduct = prod;
                             bestI = i;
                             bestJ = j;
                             
                         }
                     }
                 }
            }
        return new int[]{bestI, bestJ};
    }
}