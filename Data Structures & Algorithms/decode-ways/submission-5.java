class Solution {
    public int numDecodings(String s) {
        if (s== null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 1;i<s.length();i++){
            int current = 0;
            int num = Character.getNumericValue(s.charAt(i));
            int twoDigit = Integer.parseInt(s.substring(i-1,i+1));
            if (num >= 1) current+= prev1;
            if (twoDigit >= 10 && twoDigit <= 26) current+= prev2;
            if (current == 0) return 0;

            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
