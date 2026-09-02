class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // -4,-1,-1,0,1,2
        // i left right
        //-1,0,1,2,3,4,5
        for (int i = 0;i<nums.length;i++){
            if (nums[i] >  0){
                break;
            }
            
            if (i>0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[left]);
                    sub.add(nums[right]);
                    result.add(sub);

                    left++;
                    right--;

                    while(left<right && nums[left] == nums[left-1]) left++;

                    while(left< right && nums[right] == nums[right+1]) right--;

                }

                else if ( sum < 0){
                    left++;
                }
                else right--;
            }

        }
        return result;
    }
}
