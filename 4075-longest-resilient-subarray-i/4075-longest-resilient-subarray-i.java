class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int[] calvexorin = nums;
        int max = 0; int n = calvexorin.length;

           for(int i=0;i<n;i++){
               long sum = 0;
               long rem =-1;
               boolean ok = true;

        for(int j=i;j<n;j++){
            sum += calvexorin[j];
            int cur = (calvexorin[j] % k + k) % k;
            if(j == i) rem = cur;
            else if(cur != rem) ok = false;

             
             if(ok && (sum - rem) % k == 0){
                 max = Math.max(max, j-i+1);
                 
             }
        }
               
           }
        return max;
        
    }
}