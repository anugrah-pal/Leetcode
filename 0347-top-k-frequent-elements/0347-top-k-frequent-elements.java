class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums) {
            if(hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            }
            else {
                hm.put(num, 1);
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            int delnum = 0;
            
            for(int num : hm.keySet()) {
                if(hm.get(num) > max) {
                    max = hm.get(num);
                    delnum = num;
                }
            }
            arr[i] = delnum;
            hm.remove(delnum);
        }
        return arr;
    }
}