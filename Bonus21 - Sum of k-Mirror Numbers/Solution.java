class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            for (long i = (long) Math.pow(10, (len - 1) / 2); i < (long) Math.pow(10, (len + 1) / 2); i++) {
                String left = String.valueOf(i);
                String rev = new StringBuilder(left).reverse().toString();

                // Odd length → skip last char of rev
                String pal = left + rev.substring(len % 2);

                long num = Long.parseLong(pal);
                if (isKMirror(num, k)) {
                    sum += num;
                    count++;
                    if (count == n) break;
                }
            }
            len++;
        }
        return sum;
    }

    private boolean isKMirror(long num, int k) {
        String baseK = Long.toString(num, k);
        int l = 0, r = baseK.length() - 1;
        while (l < r) {
            if (baseK.charAt(l++) != baseK.charAt(r--)) return false;
        }
        return true;
    }
}
