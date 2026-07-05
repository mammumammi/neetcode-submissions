class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <=1) return intervals;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while(i<n){
            int start = intervals[i][0];
            int end = intervals[i][1];

            while(i<n-1 && intervals[i+1][0]<= end){
                i++;
                start = Math.min(start,intervals[i][0]);
                end = Math.max(end,intervals[i][1]);
            }

            int[] merge = new int[]{start,end};
            result.add(merge);

            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
