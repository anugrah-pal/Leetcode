class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int mj1 = 0, mj2 = 0, c1 = 0, c2 = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == mj1) {
                c1++;
            }
            else if(nums[i] == mj2) {
                c2++;
            }
            else if(c1 == 0) {
                mj1 = nums[i];
                c1 = 1;
            }
            else if(c2 == 0) {
                mj2 = nums[i];
                c2 = 1;
            }
            else {
                c1--;
                c2--;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        c1 = 0; c2 = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == mj1) {
                c1++;
            }
            else if(nums[i] == mj2) {
                c2++;
            }
        }

        if(c1 > n / 3) {
            ans.add(mj1);
        }
        if(c2 > n / 3) {
            ans.add(mj2);
        }
        return ans;
    }
}