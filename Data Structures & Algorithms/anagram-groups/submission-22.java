class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();

        for (String str: strs){
            char[] charArray = str.toCharArray();

            Arrays.sort(charArray);

            String sorted = new String(charArray);

            if (map.containsKey(sorted)){
                map.get(sorted).add(str);
                continue;
            }
            map.put(sorted,new ArrayList<>());
            map.get(sorted).add(str);
        }

        for (List<String> strings: map.values())
            result.add(strings);

        return result;
    }
}
