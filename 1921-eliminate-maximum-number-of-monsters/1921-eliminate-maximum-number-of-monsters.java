class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] minReach = new int[dist.length];
        for(int i = 0; i < dist.length; i++) {
            minReach[i] = (int)Math.ceil((double)dist[i] / speed[i]);
            
        }
        Arrays.sort(minReach);
        int count = 0;
        for(int i = 0; i < minReach.length; i++) {
            if(i >= minReach[i]) {
                return count;
            }
            count++;
        }
        return count;
    }
}