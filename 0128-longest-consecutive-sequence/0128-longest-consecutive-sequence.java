class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num : nums) {
            hm.put(num, 1);
        }

        int longest = 0;
        for(int num : hm.keySet()) {
            if(!hm.containsKey(num - 1)) {
                int count = 1;
                int start = num;
                while(hm.containsKey(start + 1)) {
                    count++;
                    start++;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}