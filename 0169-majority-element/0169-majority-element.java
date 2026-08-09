class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int mj = 0;
        for(int i = 0; i < n; i++) {
            if(count == 0) {
                mj = nums[i];
            }
            if(mj == nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }

        return mj;
    }
}