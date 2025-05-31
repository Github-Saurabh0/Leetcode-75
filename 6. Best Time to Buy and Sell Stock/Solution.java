public class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i]; // Update lowest price
            } else {
                profit = Math.max(profit, prices[i] - buy); // Maximize profit
            }
        }

        return profit;
    }
}

// Solution2

// public class Solution2 {
//     public int maxProfit(int[] prices) {
//         int minPrice = Integer.MAX_VALUE;
//         int maxProfit = 0;

//         for (int price : prices) {
//             if (price < minPrice) {
//                 minPrice = price;
//             } else if (price - minPrice > maxProfit) {
//                 maxProfit = price - minPrice;
//             }
//         }

//         return maxProfit;
//     }
// }
