class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int maxSeen = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            maxSeen = Math.max(maxSeen, arr[i]);
            if(maxSeen == i) {
                count++;
            }
        }
        return count;
    }
}