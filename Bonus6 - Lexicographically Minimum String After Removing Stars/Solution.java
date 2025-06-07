class Solution {
    public String clearStars(String s) {
        StringBuilder result = new StringBuilder();
        TreeMap<Character, List<Integer>> map = new TreeMap<>();

        // Step 1: Store character positions
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '*') {
                result.append(c);
                map.computeIfAbsent(c, k -> new ArrayList<>()).add(result.length() - 1);
            } else {
                // Step 2: Remove the smallest char (lexicographically)
                char smallest = map.firstKey();
                List<Integer> indexes = map.get(smallest);
                int removeIndex = indexes.remove(indexes.size() - 1);
                result.setCharAt(removeIndex, '#'); // mark for removal
                if (indexes.isEmpty()) map.remove(smallest);
            }
        }

        // Step 3: Build final result, skipping removed characters
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '#')
                finalStr.append(result.charAt(i));
        }

        return finalStr.toString();
    }
}