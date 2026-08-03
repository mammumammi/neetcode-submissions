class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int jumps = 0;
        int currentEnd = 0;
        if (nums.length == 0 || nums.length == 1) return 0;
        for (int i = 0;i<nums.length;i++){
            maxReach = Math.max(maxReach,i+nums[i]);

            if (i == currentEnd){
                currentEnd = maxReach;
                jumps++;
            }

            if (currentEnd >= nums.length - 1){
                return jumps;
            }
        }
        return jumps;
    }
}
