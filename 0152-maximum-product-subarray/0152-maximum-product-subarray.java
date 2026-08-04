class Solution {
    public int maxProduct(int[] nums) {
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tempMax = maxEnding;
            int tempMin = minEnding;
            maxEnding = Math.max(nums[i], Math.max(tempMax * nums[i], tempMin * nums[i]));
            minEnding = Math.min(nums[i], Math.min(tempMax * nums[i], tempMin * nums[i]));
            ans = Math.max(ans, maxEnding);
        }
        return ans;
    }
}