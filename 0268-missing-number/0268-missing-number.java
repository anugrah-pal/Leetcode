class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i = 0; i < n + 1; i++) {
            total += i;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return total - sum;
    }
}