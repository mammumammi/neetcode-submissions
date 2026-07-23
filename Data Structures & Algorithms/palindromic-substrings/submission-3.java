class Solution {
    public int countSubstrings(String s) {
        int total = 0;

        for (int i = 0;i<s.length();i++){
            int count1 = expandFromCenter(i,i,s);
            int count2 = expandFromCenter(i,i+1,s);

            total+=count1+count2;
        }

        return total;
    }

    private int expandFromCenter(int left,int right,String s){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }

        return count;
    }
}
