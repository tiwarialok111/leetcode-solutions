class Solution {
    public void moveZeroes(int[] nums) {
          int left = 0;
        //   int right = right-1;
            
            for(int i=0;i<nums.length;i++){
                if(nums[i] != 0){
                    int temp = nums[left];
                    nums[left] = nums[i];
                    nums[i] = temp;
                    left++;

                }

            }
        

    }
}