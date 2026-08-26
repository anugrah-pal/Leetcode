class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : nums) {
            if(hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            }
            else {
                hm.put(num, 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(!hm.containsKey(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}