public class Solution1 {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char c1, c2;

        while (left < right) {
            c1 = s.charAt(left);
            c2 = s.charAt(right);

            if (!((c1 >= 'A' && c1 <= 'Z') || (c1 >= 'a' && c1 <= 'z') || (c1 >= '0' && c1 <= '9'))) {
                left++;
                continue;
            }

            if (!((c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || (c2 >= '0' && c2 <= '9'))) {
                right--;
                continue;
            }

            // Normalize both characters to lowercase manually
            if (c1 >= 'A' && c1 <= 'Z') c1 += 32;
            if (c2 >= 'A' && c2 <= 'Z') c2 += 32;

            if (c1 != c2) return false;

            left++;
            right--;
        }

        return true;
    }
}