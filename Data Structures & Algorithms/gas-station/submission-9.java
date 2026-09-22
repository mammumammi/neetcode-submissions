class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentTank = 0;
        int tankSurplus = 0;
        int startIndex = 0;
        for (int i = 0;i<gas.length;i++){
            int diff = gas[i] - cost[i];
            tankSurplus += diff;
            currentTank += diff;

            if (currentTank < 0){
                currentTank = 0;
                startIndex = i + 1;
            }
        }

        return (tankSurplus < 0) ? -1 : startIndex;

    }
}
