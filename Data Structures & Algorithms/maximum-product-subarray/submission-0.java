class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i =1;i<nums.length;i++){
            int current = nums[i];

            if (current < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(current,current*max);
            min = Math.min(current,current*min);

            result = Math.max(result,max);
        }
        return result;
    }
}
