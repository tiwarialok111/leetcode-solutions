class Solution {
    public int minAddToMakeValid(String s) {
        int openParen = 0;
        int closeParen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openParen++;
            } else if (c == ')') {
                if (openParen > 0) {
                    openParen--; 
                } else {
                    closeParen++;
                }
            }
        }

        return openParen + closeParen;
    }
}