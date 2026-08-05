class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(!hs.contains(nums[i])) {
                hs.add(nums[i]);
            }
        }

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        int smallest = nums[0];
        int largest = nums[nums.length - 1];
        
        for(int i = smallest + 1; i < largest; i++) {
            if(!hs.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
        
    }
}