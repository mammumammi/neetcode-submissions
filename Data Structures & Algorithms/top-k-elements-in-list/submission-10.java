class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];
        for (int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        for (int i = 0;i<k;i++){
            int max = 0;
            int value = 0;
            for (int key: map.keySet()){
                int curr = map.get(key);
                if (curr > max){
                    max = curr;
                    value =key;
                }
            }
            map.put(value,0);
            res[i] = value;
        }
        return res;
    }
}
