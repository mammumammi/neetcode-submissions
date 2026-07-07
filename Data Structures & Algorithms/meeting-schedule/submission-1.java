/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return true;

        if (intervals.size() == 1) return true;

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));
        int prevEnd = (intervals.get(0)).end;
        //[5,10],[0,3],[3,6]
        //[0,3],[3,6],[5,10]
        //p = 3 3 > 3 
        //p = 6 6>5
        for (int i = 1;i<intervals.size();i++){
            if (prevEnd>intervals.get(i).start){
                return false;
            }
            prevEnd = intervals.get(i).end;
        }
        return true;
    }
}
