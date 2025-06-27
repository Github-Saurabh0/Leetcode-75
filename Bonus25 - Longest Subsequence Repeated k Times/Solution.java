import java.util.*;

public class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        // candidate chars that can appear at least k times
        List<Character> candidates = new ArrayList<>();
        for (char c = 'z'; c >= 'a'; c--) {
            if (freq[c - 'a'] >= k) {
                candidates.add(c);
            }
        }

        return dfs(s, k, candidates);
    }

    private String dfs(String s, int k, List<Character> candidates) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        String result = "";

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (char c : candidates) {
                String next = curr + c;

                if (isValid(s, next, k)) {
                    queue.offer(next);
                    if (next.length() > result.length() || 
                        (next.length() == result.length() && next.compareTo(result) > 0)) {
                        result = next;
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String s, String target, int k) {
        int index = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == target.charAt(index)) {
                index++;
                if (index == target.length()) {
                    count++;
                    index = 0;
                    if (count == k) return true;
                }
            }
        }
        return false;
    }
}
