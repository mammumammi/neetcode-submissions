class Solution {
    public String longestPalindrome(String s) {
        //expand from center
        String result = "";String p1,p2;
        for (int i = 0;i<s.length();i++){
            p1 = expandFromCenter(i,i,s,result);
            p2 = expandFromCenter(i,i+1,s,result);

            if (p1.length() > result.length()) result = p1;
            if (p2.length() > result.length()) result = p2;
        }

        return result;
    }

    private String expandFromCenter(int left,int right,String s,String result){
        

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left + 1,right);


    }
}
