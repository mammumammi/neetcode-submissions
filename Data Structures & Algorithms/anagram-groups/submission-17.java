class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> words = new HashMap<>();

        List<List<String>> results = new ArrayList<>();
        for (String str:strs){
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

        for (List<String> val: words.values()){
            results.add(val);
        }
        return results;
    }
}
