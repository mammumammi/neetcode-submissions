class Solution {
    public boolean canJump(int[] nums) {
        //[1,2,0,1,0]
        //maxReach = 1 i = 1
        //maxReach = 1+ 2 = 3  i =2
        //maxReach = 1 + 2 + 0 = 3 i = 3
        //maxReach = 1 +2 +  1  = 1000 i =4

        int maxReach = 0;
        for (int i = 0;i<nums.length;i++){
            if (i>maxReach){
                return false;
            }

            maxReach = Math.max(maxReach,i+nums[i]);

            if (maxReach >= nums.length - 1) return true;
        }        

        return false;

    }
}
