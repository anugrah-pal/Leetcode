class Solution {
    public int maxChunksToSorted(int[] arr) {
    //     int count = 0;
    //     int prefixMax = Integer.MIN_VALUE;
       
    //     for(int i = 0; i < arr.length - 1; i++) {
    //         prefixMax = Math.max(prefixMax, arr[i]);

    //         int suffixMin = Integer.MAX_VALUE;
    //         for(int j = i + 1; j < arr.length; j++) {
    //             suffixMin = Math.min(suffixMin, arr[j]);
    //         }
    //         if(prefixMax <= suffixMin) {
    //             count++;
    //         }
    //     }
    //     return count + 1;


        int count = 0;
        int prefixMax = Integer.MIN_VALUE;

        int[] suffixMin = new int[arr.length];
        suffixMin[arr.length - 1] = arr[arr.length - 1];
        int suffixmin = suffixMin[arr.length - 1];
        for(int i = arr.length - 1; i >= 0; i--) {
            suffixmin = Math.min(arr[i], suffixmin);
            suffixMin[i] = suffixmin;
        }

        for(int i = 0; i < arr.length - 1; i++) {
            prefixMax = Math.max(prefixMax, arr[i]);
            if(prefixMax <= suffixMin[i + 1]) {
                count++;
            }
        }
        return count + 1;
    }
}