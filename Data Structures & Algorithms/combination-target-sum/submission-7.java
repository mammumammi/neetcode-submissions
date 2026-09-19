class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0,nums,target,new ArrayList<>(),result);

        return result;
    }

    private void backtrack(int start,int[] nums,int target,List<Integer> current,List<List<Integer>> result){
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        else if (target < 0) return;

        for (int i = start;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(i,nums,target - nums[i],current,result);
            current.remove(current.size() - 1);
        }
    }
}
