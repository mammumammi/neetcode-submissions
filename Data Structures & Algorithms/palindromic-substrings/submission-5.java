class Solution {
        int count = 0;
    public int countSubstrings(String s) {

        count = 0;
        for (int i = 0;i<s.length();i++){
            expandFromCenter(i,i,s);
            expandFromCenter(i,i+1,s);

        }

        return count;
    }

    private void expandFromCenter(int left,int right,String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }
}
