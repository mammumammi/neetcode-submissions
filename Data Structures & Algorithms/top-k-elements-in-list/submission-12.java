class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int[] result = new int[k];
        int prevMax = Integer.MIN_VALUE;
        for (int i = 0;i<k;i++){
            int max =Integer.MIN_VALUE;
            int maxKey = 0;
            for (int key: map.keySet()){
                if (map.get(key) > max){
                    max = map.get(key);
                    maxKey = key;
                }
            }
            result[i] = maxKey;
            prevMax = max;
            map.remove(maxKey);
        }
        return result;
    }
}
