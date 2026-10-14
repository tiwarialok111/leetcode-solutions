class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 0 || sum > 9 * num) {
            return "";
        }
        char[] result = new char[num];
        for (int i = 0; i < num; i++) {
            int d = Math.min(9, sum);
            result[i] = (char) ('0' + d);
            sum -= d;
        }
        return new String(result);
    }
}