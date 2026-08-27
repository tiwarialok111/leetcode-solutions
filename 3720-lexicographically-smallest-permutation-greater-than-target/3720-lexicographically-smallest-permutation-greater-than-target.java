class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int matchLen = -1;
        int bumpChar = -1;

        int[] currentFreq = freq.clone();
        for (int i = 0; i < n; i++) {
            char tChar = target.charAt(i);
            
            // Find the SMALLEST character strictly greater than target[i]
            for (int c = tChar - 'a' + 1; c < 26; c++) {
                if (currentFreq[c] > 0) {
                    matchLen = i;
                    bumpChar = c;
                    break; // Stop at the first (smallest) candidate > target[i]
                }
            }

            if (currentFreq[tChar - 'a'] > 0) {
                currentFreq[tChar - 'a']--;
            } else {
                break;
            }
        }

        if (matchLen == -1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int[] finalFreq = freq.clone();

        for (int i = 0; i < matchLen; i++) {
            char tChar = target.charAt(i);
            sb.append(tChar);
            finalFreq[tChar - 'a']--;
        }

        sb.append((char) ('a' + bumpChar));
        finalFreq[bumpChar]--;

        for (int c = 0; c < 26; c++) {
            while (finalFreq[c] > 0) {
                sb.append((char) ('a' + c));
                finalFreq[c]--;
            }
        }

        return sb.toString();
    }
}