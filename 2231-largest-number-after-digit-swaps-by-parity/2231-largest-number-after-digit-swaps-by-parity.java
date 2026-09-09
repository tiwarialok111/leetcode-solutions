class Solution {
    public int largestInteger(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (char c : digits) {
            int val = c - '0';
            if (val % 2 == 0) {
                evens.add(val);
            } else {
                odds.add(val);
            }
        }

        Collections.sort(evens, Collections.reverseOrder());
        Collections.sort(odds, Collections.reverseOrder());

        int evenIdx = 0;
        int oddIdx = 0;
        int result = 0;

        for (char c : digits) {
            int val = c - '0';
            if (val % 2 == 0) {
                result = result * 10 + evens.get(evenIdx++);
            } else {
                result = result * 10 + odds.get(oddIdx++);
            }
        }

        return result;
    }
}