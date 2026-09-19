class Solution {
    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0;i<s.length();i++){
            String str1 = expandFromCenter(i,i,s);
            String str2 = expandFromCenter(i,i+1,s);
            String str = (str1.length() > str2.length()) ? str1 : str2;
            result = (str.length() > result.length()) ? str : result;
        }

        return result;
    }

    private String expandFromCenter(int left,int right,String s){
        while (left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left + 1,right);
    }
}
