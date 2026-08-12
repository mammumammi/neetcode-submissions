class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int[] og = temperatures;
        for (int i = 0;i<n-1;i++){
            int count = 0;
            for (int j = i +1;j<n;j++){
                
                if (og[i]<og[j]){
                    result[i] = ++count;
                    break;
                }
                else{
                    count++;
                    if (j== n-1) result[i] = 0;
                }
            }
        }

        return result;
    }
}
