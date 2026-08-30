class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,target,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(int idx,int[] nums,int target,List<Integer> current,List<List<Integer>> result){
        
        if (target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx;i<nums.length;i++){
            if (i > idx && nums[i] == nums[i-1]) continue;

            if (nums[i] > target) break;

            current.add(nums[i]);
            backtrack(i+1,nums,target - nums[i],current,result);
            current.remove(current.size() - 1);
        }
    }
}
