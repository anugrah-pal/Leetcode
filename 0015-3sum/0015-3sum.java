class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Long> fans = new HashSet<>();
        Arrays.sort(nums);

        int tar = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int ntar = tar - nums[i];

            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                if(nums[l] + nums[r] == ntar) {
                    long hash = getHash(nums[i], nums[l], nums[r]);
                    if(fans.contains(hash) == false) {
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        fans.add(hash);
                    }
                    
                    l++;
                    r--;
                } else if(nums[l] + nums[r] > ntar) {
                    r--;
                } else {
                    l++;
                }       
            }
        }
        return ans;
    }
    private long getHash(int x, int y, int z) {
        long hash = x;
        hash *= 100000;
        hash += y;
        hash *= 100000;
        hash += z;

        return hash;
    }
}