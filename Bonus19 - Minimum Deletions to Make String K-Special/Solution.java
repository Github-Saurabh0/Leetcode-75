class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            int del = 0;
            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0) continue;
                if (freq[j] < freq[i]) {
                    del += freq[j]; // delete all smaller
                } else if (freq[j] - freq[i] > k) {
                    del += freq[j] - (freq[i] + k); // reduce excess
                }
            }

            res = Math.min(res, del);
        }

        return res;
    }
}
