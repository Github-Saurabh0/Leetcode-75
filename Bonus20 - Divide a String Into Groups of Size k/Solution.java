class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (n + k - 1) / k; // ceiling of n/k
        String[] result = new String[size];

        int index = 0;
        for (int i = 0; i < n; i += k) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                if (j < n) sb.append(s.charAt(j));
                else sb.append(fill);
            }
            result[index++] = sb.toString();
        }

        return result;
    }
}
