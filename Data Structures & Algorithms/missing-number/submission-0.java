class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int i =0;i<nums.length;i++){
            numbers.add(nums[i]);
        }
        int count = 0;
        for (int i =0;i<=nums.length;i++){
            if (!numbers.contains(i)){
                count=i;
            }
        }

        return count;
    }
}
