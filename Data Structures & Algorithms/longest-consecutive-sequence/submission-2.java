class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
       Arrays.sort(nums);
       
       int min = nums[0];
        int count = 1;
        int maxCount = 1;
        for (int i = 1;i<nums.length;i++){
            if (nums[i] == min){
                continue;
            }
            else if(nums[i] == min + 1){
                count++;
                min = nums[i];
            }

            else{
                maxCount = Math.max(maxCount,count);
                count = 1;
                min = nums[i];
            }
        }

       return Math.max(count,maxCount);
    }
}
