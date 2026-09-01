class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0;i<s.length();i++){
            int c1 = expandFromCenter(i,i,s);
            int c2 = expandFromCenter(i,i+1,s);
            count+=c1 +c2;
        }

        return count;
    }

    private int expandFromCenter(int left,int right,String s){
        int count = 0;
        while(left >= 0  && right <s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
