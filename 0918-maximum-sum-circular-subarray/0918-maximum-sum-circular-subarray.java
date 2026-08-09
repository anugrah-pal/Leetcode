class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;
        int currSum = nums[0];
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += nums[i];
        }
        for(int i = 1; i < n; i++) {
            currSum = Math.min(nums[i], currSum + nums[i]);
            minSum = Math.min(currSum, minSum);
        }
        int maxSum = Integer.MIN_VALUE;
        int csum = 0;
        for(int i = 0; i < n; i++) {
            csum = Math.max(nums[i], csum + nums[i]);
            maxSum = Math.max(csum, maxSum);
        }

        if(maxSum < 0) {
            return maxSum;
        }
        return Math.max(maxSum, total - minSum);
    }
}