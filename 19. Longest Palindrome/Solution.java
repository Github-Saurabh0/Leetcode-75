class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];  // ASCII size for all characters
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        for (int freq : count) {
            length += freq / 2 * 2;  // Add the largest even part of each character count
            if (length % 2 == 0 && freq % 2 == 1) {
                length += 1; // Add one odd character in center if possible
            }
        }

        return length;
    }
}