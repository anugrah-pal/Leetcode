class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int l = n * (n + 1) / 2;
        long[] arr = new long[l];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            long sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                arr[idx++] = sum;
            }
            
        }
        Arrays.sort(arr);
        int MOD = 1000000007;
        long ans = 0;
        for(int i = left - 1; i < right; i++) {
            ans += arr[i];
            ans = ans % MOD;
        }
        return (int)ans;

    }
}