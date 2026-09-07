class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int currentEnd = 0;
        int minJumps = 0;
        if (nums.length <=1) return 0;
        for (int i = 0;i<nums.length;i++){
            if (i > maxReach ) break;

            maxReach = Math.max(maxReach,i + nums[i]);

            if (i == currentEnd){
                minJumps++;
                currentEnd = maxReach;

                if (maxReach >= nums.length - 1) break;
            }

            
        }

        return minJumps;
    }
}
