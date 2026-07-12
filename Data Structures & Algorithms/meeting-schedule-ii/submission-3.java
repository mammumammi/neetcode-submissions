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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        for (Interval item:intervals){
            startTimes.add(item.start);
            endTimes.add(item.end);
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int rooms = 0;
        int endPtr = 0;

        for (int i = 0;i<startTimes.size();i++){
            if (startTimes.get(i) < endTimes.get(endPtr)){
                rooms++;
            }
            else{
                endPtr++;
            }
        }
        return rooms;
    }
}
