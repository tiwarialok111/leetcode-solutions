
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                sorted = false;
                break;
            }
        }

        if (sorted) return 0;
        if (n == 2) return -1;

        char minChar = 'z';
        char maxChar = 'a';

        for (int i = 0; i < n; i++) {
            minChar = (char) Math.min(minChar, s.charAt(i));
            maxChar = (char) Math.max(maxChar, s.charAt(i));
        }

        // One operation is enough if either boundary is already correct.
        if (s.charAt(0) == minChar ||
            s.charAt(n - 1) == maxChar) {
            return 1;
        }

        // If the maximum is at the start and the minimum
        // is at the end, check whether both are unique.
        if (s.charAt(0) == maxChar &&
            s.charAt(n - 1) == minChar) {

            int countMin = 0;
            int countMax = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == minChar) countMin++;
                if (s.charAt(i) == maxChar) countMax++;
            }

            if (countMin == 1 && countMax == 1) {
                return 3;
            }
        }

        return 2;
    }
}
