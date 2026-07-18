class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int start = 0;

        for (int i =0;i<s.length();i++){
            int[] len1 = expandCenter(s,i,i);
            int[] len2 = expandCenter(s,i,i+1);

            int[] currentMax = len1[0]>len2[0] ? len1 : len2;

            if (currentMax[0] > maxLength){
                maxLength = currentMax[0];
                start = currentMax[1];
            }
        }

        return s.substring(start,start + maxLength);
    }

    private int[] expandCenter(String s,int left,int right){
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int[] res= new int[2];
        res[0] = right - left - 1;
        res[1] = left + 1;
        return  res;
    }
}
