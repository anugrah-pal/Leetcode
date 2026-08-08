class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int p1 = -1;
        int nl = nums.length;
        

        for(int i = nl - 1; i > 0 ; i--) {
            if(nums[i] > nums[i - 1]) {
                p1 = i - 1;
                break;
            }
        }

        if(p1 == -1) {
            return -1;
            // int st = 0, en = nl - 1;
            // while(st < en) {
            //     char temp1 = nums[st];
            //     nums[st] = nums[en];
            //     nums[en] = temp1;
            //     st++;
            //     en--;
            // }
            // long ans = Long.parseLong(new String(nums));
            // if(ans > Integer.MAX_VALUE) {
            //     // System.out.print(-1);
            //     return -1;
            // }
            // // System.out.print((int)ans);
            // return (int)ans;
        }

        int p2 = -1;
        for(int i = nl - 1; i > p1; i--) {
            if(nums[i] > nums[p1]) {
                p2 = i;
                break;
            }
        }

        char temp2 = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp2;

        int st = p1 + 1;
        int en = nl - 1;
        while(st < en) {
            char temp3 = nums[st];
            nums[st] = nums[en];
            nums[en] = temp3;
            st++;
            en--;
        }
        long ans = Long.parseLong(new String(nums));
        if(ans > Integer.MAX_VALUE) {
            // System.out.print(-1);
            return -1;
        }
        // System.out.print((int)ans);
        return (int)ans;
     }
}