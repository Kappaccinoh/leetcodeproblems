public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        int c = matrix[0].length;
        int mid = 0;

        while (l <= r) {
            mid = l + (r - l) / 2;
            
            if (matrix[mid / c][mid % c] == target) {
                return true;
            } else if (target > matrix[mid / c][mid % c]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}