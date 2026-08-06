class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int prefixMax = Integer.MIN_VALUE;
       
        for(int i = 0; i < arr.length - 1; i++) {
            prefixMax = Math.max(prefixMax, arr[i]);

            int suffixMin = Integer.MAX_VALUE;
            for(int j = i + 1; j < arr.length; j++) {
                suffixMin = Math.min(suffixMin, arr[j]);
            }
            if(prefixMax <= suffixMin) {
                count++;
            }
        }
        return count + 1;
    }
}