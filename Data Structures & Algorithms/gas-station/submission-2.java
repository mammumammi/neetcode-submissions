class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startingStation = 0;
        int currentTank = 0;
        int tankSurplus = 0;

        for (int i = 0;i<gas.length;i++){
            int netGas = gas[i] - cost[i];
            tankSurplus += netGas;
            currentTank += netGas;

            if (currentTank < 0){
                currentTank = 0;
                startingStation = i +1;
            }
        }

        return (tankSurplus >= 0) ? startingStation : -1;
    }
}
