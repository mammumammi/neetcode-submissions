class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] == 0) return - 1;
        int jumps = 0;
        int currentEnd = 0;
        int maxReach = 0;

        for (int i = 0;i<nums.length;i++){
            if (maxReach < i) return -1;

            maxReach = Math.max(maxReach,i+nums[i]);

            if (i == currentEnd){
                currentEnd = maxReach;
                jumps++;
                if (maxReach >= nums.length - 1) break;
            }
        }
        return jumps;
    }
}
