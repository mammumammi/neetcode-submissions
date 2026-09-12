class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int currentTank = 0;
        int tankSurplus = 0;
        int n = gas.length;
        for (int i = 0;i<n;i++){
            currentTank += gas[i];
            tankSurplus += gas[i];

            if (currentTank - cost[i] < 0){
                start = i+1;
                currentTank = 0;
            }
            else currentTank -= cost[i];
            tankSurplus -= cost[i];
        }
        if (tankSurplus < 0) return -1;
        return start;
    }
}
