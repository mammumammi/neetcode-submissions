class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentTank = 0;
        int startStation = 0;
        int tankSurplus = 0;

        for (int i = 0;i<gas.length;i++){
            int netGas = gas[i] - cost[i];
            tankSurplus += netGas;
            currentTank += netGas;

            if (currentTank < 0){
                startStation = i +1;
                currentTank = 0;
            }
        }

        return (tankSurplus >= 0 ) ? startStation : -1;
    }
}
