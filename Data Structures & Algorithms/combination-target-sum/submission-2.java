class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0,nums,target,current,resultSet);
        return resultSet;
    }

    private void backtrack(int index,int[] nums,int target,List<Integer> current,List<List<Integer>> resultSet){
        if (target == 0){
            resultSet.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index > nums.length - 1){
            return;
        }

        current.add(nums[index]);

        backtrack(index,nums,target - nums[index],current,resultSet);

        current.remove(current.size() - 1);

        backtrack(index + 1,nums,target,current,resultSet);
    }
}
