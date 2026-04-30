class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        int newLimit = nums.length;
        int l = 0;
        int i =0;
        int repeat = 0;
        while (l <=newLimit && repeat<2){
            ans[i]=nums[l];
            l++;
            i++;
            if (l== newLimit) {
                l = 0;
                repeat++;
            }
        }
        return ans;
    }
}