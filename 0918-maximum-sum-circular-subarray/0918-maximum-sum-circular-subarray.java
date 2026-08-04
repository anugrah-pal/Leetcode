class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int currsum = nums[0];
        int minsum = Integer.MAX_VALUE;
        int totalsum = 0;
        for(int i = 0; i < n; i++) {
            totalsum += nums[i];
        }
        for(int i = 1; i < n; i++) {
            currsum = Math.min(nums[i], currsum + nums[i]);
            minsum = Math.min(minsum, currsum); 
        }
        int csum = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            csum = Math.max(nums[i], csum + nums[i]);
            maxsum = Math.max(maxsum, csum); 
        }
        if(maxsum < 0) {
            return maxsum;
        }
        return Math.max(maxsum ,totalsum - minsum);
    }
}