class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mat = new int[m][n];
        int k = 0, l = 0;
        for(int i = 0; i < m; i++) {
            int idx = 0;
            for(int j = m - 1; j >= 0; j--) {
                mat[i][idx] = matrix[j][i];
                idx++;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = mat[i][j];
            }
        }
        return;
    }
}