class Solution {

    public boolean isAnagram(String s,String t){
        int[] freq = new int[26]; //26 ascii value till a = 27

        for (char c:s.toCharArray()){
            freq[c - 'a']++;
        }

        for (char c:t.toCharArray()){
            freq[c - 'a']--;
        }

        for (int f:freq){
            if (f!= 0 ) return false;
        }

        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0;i<strs.length;i++){
            List<String> in = new ArrayList<>();
            if (visited[i]) continue;
            in.add(strs[i]);
            visited[i] = false;

            for (int j = i +1;j<strs.length;j++){
                if (isAnagram(strs[i],strs[j]) && !visited[j]){
                    in.add(strs[j]);
                    visited[j] = true;
                }
            }

            result.add(in);
        }

        return result;
    }
}
