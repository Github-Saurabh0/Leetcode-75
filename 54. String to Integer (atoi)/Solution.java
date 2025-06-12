class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        long result = 0;

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Convert digits to number
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            // Step 4: Check for overflow
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * result);
    }
}
