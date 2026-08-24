class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for(int nums : weights) {
            min = Math.max(nums, min);
            max += nums;
        }
        
        while(min < max) {
            int mid = min + (max - min) / 2;
            int reqd = reqrdays(weights, mid);
            if(reqd <= days) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return min;
        
    }
    private int reqrdays(int[] weights, int val) {
        int count = 1;
        int sum = 0;
        int idx = 0;
        while(idx < weights.length) {
            
            if(sum+ weights[idx]> val) {
                sum = 0;
                count++;
            }
            sum += weights[idx];
            idx++;
        }
        return count;
    }
}