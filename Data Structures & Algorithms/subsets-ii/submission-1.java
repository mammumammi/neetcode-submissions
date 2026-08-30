class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        backtrack(0,nums,visited,new ArrayList<>(),result);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> items: result)
            res.add(items);
        return res;
    }

    private void backtrack(int start,int[] nums,boolean[] visited,List<Integer> current,Set<List<Integer>> result){

        
        result.add(new ArrayList<>(current));

        for (int i = start;i<nums.length;i++){

            if (visited[i]) continue;

            current.add(nums[i]);
            visited[i] = true;

            backtrack(i+1,nums,visited,current,result);

            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
