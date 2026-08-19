class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for(int i=0 ; i<arr1.length ; i++){
            max = Math.max(max , arr1[i]);
        }
        int[] fre = new int[max+1];
        for(int i=0 ; i<arr1.length ; i++){
            fre[arr1[i]] = fre[arr1[i]]+1;
        }
        int idx = 0;
        for(int i=0 ; i<arr2.length ; i++){
            int a = arr2[i];
            int count = fre[a];
            while(count>0){
                arr1[idx] = a;
                idx++;
                count--;
            }
            fre[a] = 0;
        }
        for(int i=0 ; i<fre.length ; i++){
            int count = fre[i];
            while(count>0){
                arr1[idx] = i;
                idx++;
                count--;
            }
        }
        return arr1;
    }
}