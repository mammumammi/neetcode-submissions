class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int length = s.length();
        int i = 0;
        int j = length - 1;

        while(i<j){

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            while (i <j && !Character.isLetterOrDigit(s.charAt(i))) i++;

            if (s.charAt(i) != s.charAt(j)) return false;

            i++;j--;
        }
        return true;
    }
}
