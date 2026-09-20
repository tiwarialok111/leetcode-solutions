class Solution {
    public int reverseDegree(String s) {
          int answer = 0;

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            int reverseValue = 26 -(ch - 'a');
            int contribution = reverseValue * (i + 1);;
                

               answer += contribution;

            

        }
         return answer;


    }
}