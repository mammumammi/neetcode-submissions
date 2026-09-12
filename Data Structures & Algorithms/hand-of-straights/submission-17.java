class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // find hashmap after sorting
        // hashmap ile keyset find next character
        // use groupsize so that we can stop at the point where we need to stop
        //1,2,4,2,3,5,3,4
        //1,2,2,3,3,4,4,5
        int n = hand.length;
        if (n%groupSize != 0) return false;

        Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0;i<n;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0) + 1);
        }


        for (int num: hand){
            if (map.get(num) <= 0) continue;

            while (map.get(num) > 0){
                int count = 1;
                int curr = num;
                map.put(curr,map.get(curr) - 1);
                while (count < groupSize){
                    if (!map.containsKey(curr + 1) || map.get(curr+1) <= 0){
                        return false;
                    }

                    map.put(curr+1,map.get(curr+1) -1);
                    curr++;
                    count++;
                }
            }
        }

        for (int num: map.keySet()){
            if (map.get(num) != 0) return false;
        }

        return true;
    }
}
