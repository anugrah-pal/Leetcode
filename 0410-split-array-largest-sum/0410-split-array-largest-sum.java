class Solution {
    public int splitArray(int[] nums, int k) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int num : nums) {
            lo = Math.max(lo, num);
            hi += num;
        }
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int _k = subArray(nums, mid);
            if(_k <= k) {
                hi = mid - 1;
                ans = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    private int subArray(int[] nums, int mid) {
        int count = 1;
        int idx = 0;
        int csum = 0;
        while(idx < nums.length) {
            if(csum + nums[idx] > mid) {
                csum = 0;
                count++;
            }
            csum += nums[idx++];
        }
        return count;
    }
}