class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int lsum = 0;
        int total = 0;
        for(int i = 0; i < n; i++) {
            total += nums[i];
        }

        for(int i = 0; i < n; i++) {
            if(lsum == total - lsum - nums[i]) {
                return i;
            }
            lsum += nums[i];
        }
        return -1;
    }
}