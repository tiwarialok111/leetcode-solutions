class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack[++top] = i;
            } else if (c == ')') {
                int openIndex = stack[top--];
                pair[openIndex] = i;
                pair[i] = openIndex;
            }
        }

        StringBuilder sb = new StringBuilder();
        int curr = 0;
        int dir = 1;

        while (curr < n) {
            char c = s.charAt(curr);
            if (c == '(' || c == ')') {
                curr = pair[curr];
                dir = -dir;
            } else {
                sb.append(c);
            }
            curr += dir;
        }

        return sb.toString();
    }
}