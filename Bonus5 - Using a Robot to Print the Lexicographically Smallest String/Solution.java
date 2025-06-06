class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];  // har character ka frequency count
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        char minChar = 'a';  // ab tak ka smallest character

        for (char c : s.toCharArray()) {
            stack.push(c);              // har character ko robot stack mein push karo
            freq[c - 'a']--;            // us character ka count kam karo

            // minChar ko update karo jab tak freq[minChar] > 0 na ho
            while (minChar <= 'z' && freq[minChar - 'a'] == 0)
                minChar++;

            // stack ke top se characters nikaalte raho jab tak top <= minChar ho
            while (!stack.isEmpty() && stack.peek() <= minChar)
                result.append(stack.pop());
        }

        // bache hue characters stack se nikaal ke answer mein daalo
        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }
}
