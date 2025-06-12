class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // Fast lookup ke liye set banaya
        boolean[] dp = new boolean[s.length() + 1];     // dp[i] = s.substring(0, i) tak break ho sakta hai ya nahi
        dp[0] = true;                                   // Empty string always break ho sakti hai

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // Agar s[0...j] tak break ho sakta hai aur s[j...i] wordSet me hai
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;   // s[0...i] tak break ho sakta hai
                    break;          // Ek valid break mil gaya, ab next i par jao
                }
            }
        }

        return dp[s.length()];  // pura string break ho paya ya nahi
    }
}
