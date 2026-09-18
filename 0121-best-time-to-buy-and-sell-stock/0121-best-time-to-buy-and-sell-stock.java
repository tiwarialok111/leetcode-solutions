class Solution {
    public int maxProfit(int[] prices) {
       int minprice = Integer.MAX_VALUE;
       int maxProfit= 0;
         for(int i=0;i<prices.length;i++){
            if(prices[i] < minprice){
                minprice = prices[i];

            }
               int currentProfit = prices[i] - minprice;
               if(currentProfit > maxProfit){
                maxProfit = currentProfit;

               }

         }
         return maxProfit;

    }
}