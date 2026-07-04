class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length -1;
        int i = goal - 1;

        while(goal >= 0 && i >= 0){
            if (i + nums[i] >= goal){
                goal = i;
                i = goal - 1;
            }
            else{
                i--;
            }
        }
        return goal == 0;
    }
}
