class Solution {
    public int rob(int[] nums) {
        if (nums == null) return 0;

        int prev1 = 0;int prev2 = 0;

        for(int i = 0;i<nums.length;i++){
            int currentMax = Math.max(nums[i] + prev2,prev1);
            prev2 = prev1;
            prev1 = currentMax;
        }

        return prev1;
    }
}
