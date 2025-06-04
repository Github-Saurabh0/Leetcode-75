public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';  // a se digit
            if (j >= 0) sum += b.charAt(j--) - '0';  // b se digit
            result.append(sum % 2);                 // binary ka current digit
            carry = sum / 2;                        // carry nikalna
        }

        return result.reverse().toString();  // answer ko reverse karke return
    }
}