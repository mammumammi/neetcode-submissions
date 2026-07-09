class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character,Integer> total = new HashMap<Character,Integer>();

        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);

            total.put(c,total.getOrDefault(c,0) + 1);
        }

        for (int i =0;i<t.length();i++){
            char c = t.charAt(i);
            if (total.containsKey(c)){
                total.put(c,total.get(c) -1);
            }
            else return false;
        }

        Collection<Integer> values = total.values();

        for (int item:values){
            if (item!=0) return false;
        }
        return true;
    }
}
