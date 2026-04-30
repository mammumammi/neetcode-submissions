class Solution {
    public int findMin(int[] nums) {
        int min = 0;
        Arrays.sort(nums);
        return nums[0];
    }
}
