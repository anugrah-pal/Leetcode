class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int currsum = arr[0];
        int maxsum = arr[0];
        int delsum = arr[0];
        for(int i = 1; i < n; i++) {
            delsum = Math.max(currsum, delsum + arr[i]);
            currsum = Math.max(currsum + arr[i], arr[i]);

            maxsum = Math.max(maxsum, delsum);
            maxsum = Math.max(maxsum, currsum);
        }

        return maxsum;
    }
}