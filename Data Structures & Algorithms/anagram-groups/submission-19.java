class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> words = new HashMap<>();


        for (String str: strs){
            //str to sorted string
            //string immutable
            //char array mutable
            //string - > char array -> sort -> string (sortedKey)
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            if (words.containsKey(sortedKey)){
                words.get(sortedKey).add(str);
                continue;
            }
            words.put(sortedKey,new ArrayList<>());
            words.get(sortedKey).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> group: words.values()){
            result.add(group);
        }
        return result;
    }
}
