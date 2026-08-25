class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if(nums[lo] < nums[hi]) {
            return nums[lo];
        }

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if(nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return nums[0];
    }
}