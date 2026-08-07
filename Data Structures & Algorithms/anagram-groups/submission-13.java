class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       if (strs == null || strs.length == 0) return null;
        Map<String,List<String>> map = new HashMap<>();
       for (int i = 0;i<strs.length;i++){
        char[] charArray = strs[i].toCharArray();
        Arrays.sort(charArray);
        String sortedKey = new String(charArray);

        if (map.containsKey(sortedKey)){
            map.get(sortedKey).add(strs[i]);
            continue;
        }

        map.putIfAbsent(sortedKey,new ArrayList<>());
        map.get(sortedKey).add(strs[i]);
       }
        List<List<String>> res = new ArrayList<>();
       for (List<String> str: map.values()){
        res.add(str);
       }

       return res;
    }

    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     List<String> strsList = new ArrayList<>();

    //     while(sc.hasNextLine()){
    //         strsList.add(sc.nextLine());
    //     }

    //     String[] strs = strsList.toStringArray();

    //     List<List<String>> result = groupAnagrams(strs);
    //     System.out.println();
    //     System.out.print("[");
    //     for (int i = 0;i<result.size();i++){
    //         System.out.print("[");
    //         for(String str: result.get(i)){
    //             System.out.print(str + ",");
    //         }
    //         System.out.print("]");
    //         if (i!=result.size()-1) System.out.print(",");
    //     }
    //     System.out.print("]");

    // }
}
