import java.util.HashMap;
import java.util.Map;
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

// This solution has a time complexity of O(n) because it only needs to iterate through the array once, and a space complexity of O(n) because in the worst case, it needs to store all elements of the array in the map.


// import java.util.HashMap;
// import java.util.Map;
// public class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
//                 return true;
//             }
//             map.put(nums[i], i);
//         }
//         return false;
//     }
// }
