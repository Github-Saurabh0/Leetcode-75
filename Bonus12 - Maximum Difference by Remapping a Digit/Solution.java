class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        // Maximize the number
        char targetMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                targetMax = c;
                break;
            }
        }

        String maxNum = s;
        if (targetMax != ' ') {
            maxNum = s.replace(targetMax, '9');
        }

        // Minimize the number
        char targetMin = s.charAt(0);
        String minNum = s.replace(targetMin, '0');

        return Integer.parseInt(maxNum) - Integer.parseInt(minNum);
    }
}
