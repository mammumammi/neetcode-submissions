class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int l = 0;int r = s.length() - 1;

        while ( l< r){
            while ( l< r && !alphaNum(s.charAt(l))) l++;
            while ( l<r && !alphaNum(s.charAt(r))) r--;

            if (s.charAt(l) != s.charAt(r)) return false;

            l++;r--;
        }

        return true;
    }

    public boolean alphaNum(char c){
        return ( c >= 'a' && c <= 'z' || c >= '0' && c <= '9');
    }
}
