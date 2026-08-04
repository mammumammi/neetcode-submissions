class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentTank = 0;
        int startStation = 0;
        int tankSurplus = 0;

        for (int i = 0;i<gas.length;i++){
            int netGas = gas[i] - cost[i];//one station - true gas
            tankSurplus += netGas;//to check whether we can reach the same station 
            currentTank += netGas; // to check if the current station can be reach meaning it shouldnt go to 0 or less

            if (currentTank < 0){
                startStation = i + 1;
                currentTank = 0;
            }


        }

        return (tankSurplus >= 0) ? startStation : -1;
    }
}
