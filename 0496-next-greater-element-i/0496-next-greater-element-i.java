class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // int n1 = nums1.length;
        // int n2 = nums2.length;

        // int[] arr1 = new int[n1];

        // int[] arr2 = new int[n2];
        // for(int i = 0; i < n2; i ++) {
        //     arr2[i] = -1;
        //     for(int j = i + 1; j < n2; j++) {
        //         if(nums2[i] < nums2[j]) {
        //             arr2[i] = nums2[j];
        //             break;
        //         }
        //     }
        // }
        // arr2[n2 - 1] = -1;

        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for(int i = 0; i < n2; i++) {
        //     hm.put(nums2[i], i);
        // }
        
        // for(int i = 0; i < n1; i++) {
        //     if(hm.containsKey(nums1[i])) {
        //         int idx = hm.get(nums1[i]);
        //         arr1[i] = arr2[idx];
        //     }
        // }

        // return arr1;

        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        Stack<Integer> stack = new Stack<>();
        for(int i = n2 - 1; i >=0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                arr2[i] = -1;
            }
            else {
                arr2[i] = stack.peek();
            }
            stack.push(nums2[i]);
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n2; i++) {
            hm.put(nums2[i], i);
        }

        for(int i = 0; i < n1; i++) {
            if(hm.containsKey(nums1[i])) {
                int idx = hm.get(nums1[i]);
                arr1[i] = arr2[idx];
            }
        }

        return arr1;
    }
}