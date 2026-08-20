class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;
        for(int nums : arr1) {
            max = Math.max(nums, max);
        }
        int[] arr = new int[max + 1];
        for(int nums : arr1) {
            arr[nums] = arr[nums] + 1;
        }

        int idx = 0;
        for(int nums : arr2) {
            while(arr[nums] > 0) {
                arr1[idx] = nums;
                idx++;
                arr[nums]--;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            while(arr[i] > 0) {
                arr1[idx] = i;
                idx++;
                arr[i]--;
            }
        }
        return arr1;
    }
}