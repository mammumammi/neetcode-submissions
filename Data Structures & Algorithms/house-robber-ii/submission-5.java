class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int first = robs(nums,0,nums.length - 1);
        int second = robs(nums,1,nums.length);

        return Math.max(first,second);
    }
    // [1,2(first),3,4(2nd)]
    private int robs(int[] nums,int start,int end){
        int prev1 = 0;
        int prev2 = 0;

        for (int i =start;i<end;i++){
            // [2,9,8,3,6] 9+0,2 -> 9,2+8 -> 10,3+8 -> 11,6+8 -> 14
            int currentMax = Math.max(prev1,prev2 + nums[i]);
            prev2 = prev1;
            prev1 = currentMax;
        }

        return prev1;
    }
}
