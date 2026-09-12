class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();

        for (int num: hand){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for (int num: hand){
            if (map.get(num) <= 0) continue;

            while (map.get(num) > 0){
                int count = 1;
                int curr = num;
                map.put(curr,map.get(curr) - 1);
                while (count < groupSize){
                    if (!map.containsKey(curr + 1) || map.get(curr + 1) <= 0)
                        return false;

                    map.put(curr + 1,map.get(curr + 1) - 1);
                    count++;
                    curr++;
                }
            }
        }

        for (int num :map.keySet()){
            if (map.get(num) != 0) return false;
        }

        return true;
    }
}
