class Solution {
    public void nextPermutation(int[] nums) {
        int p1 = -1;
        for(int i = nums.length - 1; i > 0 ; i--) {
            if(nums[i] > nums[i - 1]) {
                p1 = i - 1;
                break;
            }
        }
        if(p1 == -1) {
            int st = 0;
            int en = nums.length - 1;
            while(st < en) {
                int temp3 = nums[st];
                nums[st] = nums[en];
                nums[en] = temp3;
                st++;
                en--;
            }
            return;
        }
        int p2 = -1;

        for(int i = nums.length-1;i>p1;i--){
            if(nums[i] > nums[p1]){
                p2 = i;
                break;
            }
        }

        int temp1 = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp1;

        int st = p1 + 1;
        int en = nums.length - 1;
        while(st < en) {
            int temp2 = nums[st];
            nums[st] = nums[en];
            nums[en] = temp2;
            st++;
            en--;
        }
        return;

       
    }
}