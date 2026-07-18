class Solution {
    public int countSubstrings(String s) {
        int total = 0;

        for (int i = 0;i<s.length();i++){
            int odd = expandCenter(s,i,i);
            int even = expandCenter(s,i,i+1);
            total+=odd+even;
        }

        return total;
    }

    private int expandCenter(String s,int left,int right){
        int count = 0;

        while(left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }

        return count;
    }
}
