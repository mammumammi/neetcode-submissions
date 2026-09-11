class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int minJumps = 0;

        int maxReach = 0;
        int currentEnd = 0;
        //2,4,1,1,1,1
        //i = 0 c = 0 min = 1 m = 2 c= 2
        // i = 1 c = 2 min = 1 m = 1 + 4 = 5 c = 2
        // i = 2 c = 2 min = 1 m = 5 c = 2
        for (int i = 0;i<nums.length;i++){
            if (maxReach < i) return 0;

            maxReach = Math.max(maxReach,i+nums[i]);
            
            if (i == currentEnd){
                currentEnd = maxReach;
                minJumps++;
                 if (maxReach >= nums.length -1) break;
            }

           
        }
        return minJumps;
    }
}
