class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int jumps = 0;
        int currentEnd = 0;

        for (int i = 0;i<nums.length - 1;i++){
            maxReach = Math.max(maxReach,i + nums[i]);
            if (i > maxReach){
                return -1;
            }
            // maxReach = 2
            // 2,4,1,1,1 maxReach = 5
            //1,1,1,1 maxReach = 2 + 
            if (i == currentEnd){
                jumps++;
                currentEnd = maxReach;
            }

            if (currentEnd >= nums.length - 1){
                
                break;
            }
        }

        return jumps;
    }
}
