class Solution {
  public int longestSubsequence(String s, int k) {
    int oneCount = 0;
    long num = 0;
    long pow = 1;

    for (int i = s.length() - 1; i >= 0; --i) {
      if (s.charAt(i) == '1') {
        if (pow <= k && num + pow <= k) {
          ++oneCount;
          num += pow;
        }
      }
      if (pow > k) break;
      pow *= 2;
    }

    long zeroCount = s.chars().filter(c -> c == '0').count();
    return (int)(zeroCount + oneCount);
  }
}