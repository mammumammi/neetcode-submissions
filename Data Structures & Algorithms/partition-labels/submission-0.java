class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];

        for (int i = 0;i<s.length();i++){
            char ch =s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int boundary = 0;
        for (int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            boundary = Math.max(boundary,lastIndex[ch - 'a']);
            if (i == boundary){
                result.add(boundary - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
