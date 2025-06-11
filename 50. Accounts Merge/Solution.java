class Solution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, String> parent = new HashMap<>();
    Map<String, String> emailToName = new HashMap<>();

    // Step 1: Initialize union-find
    for (List<String> acc : accounts) {
      String name = acc.get(0);
      for (int i = 1; i < acc.size(); i++) {
        String email = acc.get(i);
        parent.putIfAbsent(email, email);
        emailToName.put(email, name);
        union(parent, email, acc.get(1));
      }
    }

    // Step 2: Group by root parent
    Map<String, List<String>> components = new HashMap<>();
    for (String email : parent.keySet()) {
      String root = find(parent, email);
      components.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
    }

    // Step 3: Prepare final result
    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry : components.entrySet()) {
      List<String> group = entry.getValue();
      Collections.sort(group);
      group.add(0, emailToName.get(entry.getKey()));
      result.add(group);
    }

    return result;
  }

  private String find(Map<String, String> parent, String s) {
    if (!parent.get(s).equals(s))
      parent.put(s, find(parent, parent.get(s)));
    return parent.get(s);
  }

  private void union(Map<String, String> parent, String a, String b) {
    String rootA = find(parent, a);
    String rootB = find(parent, b);
    if (!rootA.equals(rootB))
      parent.put(rootA, rootB);
  }
}