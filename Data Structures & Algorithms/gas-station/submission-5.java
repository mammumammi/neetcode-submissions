class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentTank = 0;
        int tankSurplus = 0;
        int start = 0;
        int n = gas.length;
        //g = [1,2,3]
        //c = [2,3,2]
        // t = 1 curr = 1 curr = 0 s = 1
        // t = 1 curr = 2 curr = -1 t=-2 s = 2
        // t = 1 curr = 2 curr = 0 t = -1 s = 3
        for (int i = 0;i<n;i++){
            tankSurplus += gas[i];
            currentTank += gas[i];

            if (currentTank - cost[i] < 0){
                currentTank = 0;
                tankSurplus -= cost[i];
                start = i + 1;
            }
            else{
                currentTank -= cost[i];
                tankSurplus -= cost[i];
            }
        }
        if (tankSurplus < 0) return -1;
        return start;
    }
}
