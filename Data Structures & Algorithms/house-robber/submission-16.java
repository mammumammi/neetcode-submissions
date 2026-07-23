class Solution {
    public int rob(int[] nums) {
        //[1,2,5,9,2,11]out prev1, prev2 + nums[i]
            
        int prev1 = 0;
        int prev2 = 0;
        int n = nums.length;
        int current = 0;
        for (int i = 0;i<n;i++){
            current = Math.max(nums[i] + prev2,prev1);
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
