class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        while(top <= bottom && left <= right) {
            for(int p = left; p <= right; p++) {
                ans.add(matrix[top][p]);
            }
            top++;
            for(int p = top; p <= bottom; p++) {
                ans.add(matrix[p][right]);
            }
            right--;
            if(top <= bottom) {
                for(int p = right; p >= left; p--) {
                    ans.add(matrix[bottom][p]);
                }
                bottom--;
            }
            if(left <= right) {
                for(int p = bottom; p >= top; p--) {
                    ans.add(matrix[p][left]);
                }
                left++;
            }
        }

        return ans;
    }
}