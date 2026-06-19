class Solution {
    public int countSubstrings(String s) {
        int totalCount = 0;
        for (int i=0;i<s.length();i++){
            int oddCount = expandFromCenter(s,i,i);
            int evenCount = expandFromCenter(s,i,i+1);
            totalCount += oddCount + evenCount;
        }
        return totalCount;
    }
    private int expandFromCenter(String s,int left,int right){
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
