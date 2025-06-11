class Solution {
  public int maxDifference(String s, int k) {
    int ans = Integer.MIN_VALUE; // Final answer ka initial value — ab tak ka max difference track karega.

    for (Pair<Character, Character> pair : getPermutations()) {
      final char a = pair.getKey();  // First character in pair (jaise '1')
      final char b = pair.getValue(); // Second character in pair (jaise '2')

      // minDiff[parityA][parityB] => minimum (a - b) value store karta hai 
      // for all valid substrings with specific parity of a and b
      int[][] minDiff = new int[2][2];
      Arrays.stream(minDiff).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE / 2));

      // prefixA[i] => 0 se i-1 tak 'a' character ki frequency
      List<Integer> prefixA = new ArrayList<>(List.of(0));
      // prefixB[i] => 0 se i-1 tak 'b' character ki frequency
      List<Integer> prefixB = new ArrayList<>(List.of(0));

      for (int l = 0, r = 0; r < s.length(); ++r) {
        // Current character tak ka prefix sum update karte jao
        prefixA.add(prefixA.get(prefixA.size() - 1) + (s.charAt(r) == a ? 1 : 0));
        prefixB.add(prefixB.get(prefixB.size() - 1) + (s.charAt(r) == b ? 1 : 0));

        // Jab tak window size k se bada hai aur usme a & b dono available hain, left pointer move karo
        while (r - l + 1 >= k &&
               prefixA.get(l) < prefixA.get(prefixA.size() - 1) && // 'a' kam se kam 1 ho
               prefixB.get(l) < prefixB.get(prefixB.size() - 1)) { // 'b' kam se kam 1 ho
          
          // parity (odd/even) ke hisaab se minimum difference update karo
          int pa = prefixA.get(l) % 2;
          int pb = prefixB.get(l) % 2;
          minDiff[pa][pb] = Math.min(minDiff[pa][pb], prefixA.get(l) - prefixB.get(l));
          ++l; // window chhoti karo (left pointer badhao)
        }

        // current window ka prefix difference calculate karo
        int currA = prefixA.get(prefixA.size() - 1);
        int currB = prefixB.get(prefixB.size() - 1);
        int pa = 1 - (currA % 2);
        int pb = currB % 2;

        // Maximize the answer with current difference minus previous minDiff
        ans = Math.max(ans, (currA - currB) - minDiff[pa][pb]);
      }
    }

    return ans; // Final result return karo
  }

  private List<Pair<Character, Character>> getPermutations() {
    // 0 to 4 tak ke characters ke unique ordered pairs generate karo (a != b)
    List<Pair<Character, Character>> permutations = new ArrayList<>();
    for (final char a : "01234".toCharArray())
      for (final char b : "01234".toCharArray())
        if (a != b)
          permutations.add(new Pair<>(a, b));
    return permutations;
  }
}
