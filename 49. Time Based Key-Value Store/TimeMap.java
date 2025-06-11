class TimeMap {
  private Map<String, List<Pair<Integer, String>>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    map.computeIfAbsent(key, k -> new ArrayList<>())
       .add(new Pair<>(timestamp, value));
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key))
      return "";

    List<Pair<Integer, String>> list = map.get(key);
    int l = 0, r = list.size() - 1;
    String res = "";

    while (l <= r) {
      int m = l + (r - l) / 2;
      if (list.get(m).getKey() <= timestamp) {
        res = list.get(m).getValue();
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    return res;
  }
}
