class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //backtracking
        // bit masking
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0,nums,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(int start ,int[] nums,List<Integer> current,List<List<Integer>> result){
        result.add(new ArrayList<>(current));
        //[],[1],[1,2],[1,2,3],[2,3],[3],[2],[1,3]
        for (int i = start;i<nums.length;i++){
            current.add(nums[i]);//[1]
            backtrack(i+1,nums,current,result);
            current.remove(current.size() - 1);
        }
    }
}
