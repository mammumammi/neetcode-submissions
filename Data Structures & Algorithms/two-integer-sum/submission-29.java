class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0;i<nums.length;i++){
            int comp = target - nums[i];

            if (map.containsKey(comp)){
                res[1] = i;
                res[0] = map.get(comp);
                break;
            }

            map.put(nums[i],i);
        }
        return res;
    }
}
