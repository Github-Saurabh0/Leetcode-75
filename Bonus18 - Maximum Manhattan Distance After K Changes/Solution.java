class Solution {
    public int maxDistance(String s, int k) {
        return Math.max(
            Math.max(flip(s, k, 'N', 'E'), flip(s, k, 'N', 'W')),
            Math.max(flip(s, k, 'S', 'E'), flip(s, k, 'S', 'W'))
        );
    }

    private int flip(String s, int k, char d1, char d2) {
        int maxDist = 0;
        int pos = 0;
        int opposite = 0;
        int n = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == d1 || c == d2) {
                pos++;
            } else {
                pos--;
                opposite++;
            }

            int flipGain = 2 * Math.min(k, opposite);
            maxDist = Math.max(maxDist, pos + flipGain);
        }

        return maxDist;
    }
}
