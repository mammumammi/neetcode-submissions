class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] tMap = new int[128];

        for (char c:t.toCharArray()){
            tMap[c]++;
        }

        int left = 0;int right = 0;
        int minStart = 0;int minLen = Integer.MAX_VALUE;
        int requiredCount = t.length();
        while(right < s.length()){
            char rChar = s.charAt(right);

            if (tMap[rChar] > 0){
                requiredCount--;
            }

            
            tMap[rChar]--;
            right++;

            while(requiredCount == 0){
                if (right - left < minLen){
                    minLen = right - left;
                    minStart = left;
                }

                char lChar = s.charAt(left);

                tMap[lChar]++;

                if (tMap[lChar] > 0){
                    requiredCount++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart + minLen);
    }
}
