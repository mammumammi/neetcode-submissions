class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int robFirstStreet = robLinear(nums,0,nums.length-2);
        int robSecondStreet = robLinear(nums,1,nums.length - 1);

        return Math.max(robFirstStreet,robSecondStreet);
    }

    private int robLinear(int[] nums,int start,int end){
        int prev1 = 0;
        int prev2 = 0;
        for (int i =start;i<=end;i++){
            int currentMax = Math.max(nums[i] + prev2,prev1);
            prev2 = prev1;
            prev1 = currentMax;
        }
        return prev1;
    }
}
