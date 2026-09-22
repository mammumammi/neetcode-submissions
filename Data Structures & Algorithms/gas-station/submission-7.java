class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tankSurplus = 0;
        int currentTank = 0;
        int n = cost.length;
        int startIndex = 0;
        for (int i = 0;i<n;i++){
            int diff = gas[i] - cost[i];
            tankSurplus += diff;
            currentTank += diff;

            if (currentTank < 0){
                currentTank = 0;
                startIndex = i + 1;
            }
        }

        return (tankSurplus<0) ? -1 : startIndex;
    }
}
