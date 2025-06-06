class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];  // ASCII char ke last index store karega
        int maxLen = 0;
        int start = 0;  // current window ka start

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            start = Math.max(start, index[c]);  // repeating character ko skip karo
            maxLen = Math.max(maxLen, end - start + 1);  // max length update karo
            index[c] = end + 1;  // character ka next valid position store karo
        }

        return maxLen;
    }
}
