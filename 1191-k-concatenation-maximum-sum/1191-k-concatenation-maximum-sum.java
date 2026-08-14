class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;

        long totalSum = 0;

        for (int num : arr) {

            totalSum += num;

        }

        int times = Math.min(k, 2);

        int currsum = 0;
        long maxsum = 0;
        for(int i = 0; i < n * times; i++) {
            int num = arr[i % n];

            currsum = Math.max(0, currsum + num);
            maxsum = Math.max(currsum, maxsum);
        }
        if (k > 2 && totalSum > 0) {

            maxsum += (long)(k - 2) * totalSum;

        }

        return (int)(maxsum % 1_000_000_007);
    }
}