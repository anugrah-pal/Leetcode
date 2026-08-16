class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int ans = 0;
        char[] chr = s.toCharArray();
        for(int i = 0; i < s.length() - 1; i++) {
            if(hm.get(chr[i]) >= hm.get(chr[i + 1])) {
                ans += hm.get(chr[i]);
            }
            else {
                ans -= hm.get(chr[i]);
            }
        }
        return ans + hm.get(chr[s.length() - 1]);
    }
}