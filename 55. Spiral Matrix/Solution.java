import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Output list banayi
        List<Integer> result = new ArrayList<>();

        // Edge case: agar matrix null ya empty ho
        if (matrix == null || matrix.length == 0) return result;

        // Boundaries define ki - top row, bottom row, left column, right column
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // Jab tak sab boundaries valid hai
        while (top <= bottom && left <= right) {
            // Left to Right traverse kar rahe hain top row mein
            for (int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            top++; // Top boundary niche le aaye

            // Top to Bottom traverse kar rahe hain right column mein
            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--; // Right boundary left le aaye

            // Right to Left traverse (agar bottom row abhi bhi valid hai)
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    result.add(matrix[bottom][i]);
                bottom--; // Bottom boundary upar le aaye
            }

            // Bottom to Top traverse (agar left column abhi bhi valid hai)
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++; // Left boundary right le aaye
            }
        }

        // Final result return
        return result;
    }
}
