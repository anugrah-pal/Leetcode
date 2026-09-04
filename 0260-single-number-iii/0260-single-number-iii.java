class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res = res ^ num;
        }
        int idx = -1;
        for(int i = 0; i < 31; i++) {
            if(checkBit(res, i)) {
                idx = i;
                break;
            }
        }
        int a = 0;
        int b = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & (1 << idx)) == 0) {
                a = a ^ nums[i];
            }
            else{
                b = b ^ nums[i];
            }
        }
        return new int[]{a, b};

    }
    private static boolean checkBit(int n, int i) {
      int mask = 1 << i;
      if((n & mask) == 0) {
        return false;
      }
      return true;
    }
}