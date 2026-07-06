class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int remCounter = 0;
        int prevEnd = intervals[0][1];

        for (int i =1;i<intervals.length;i++){
            if (prevEnd>intervals[i][0]){
                remCounter++;
                prevEnd = Math.min(prevEnd,intervals[i][1]);
            }
            else{
                prevEnd = intervals[i][1];
            }
            
        }

        return remCounter;
    }
}
