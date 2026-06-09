class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adjList = new HashMap<>();
        int[] visited = new int[numCourses];

        for (int i =0;i<numCourses;i++){
            adjList.put(i,new ArrayList<>());
            visited[i] = 0;
        }
        for (int[] arr:prerequisites){
            int prereq = arr[1];
            int dependentCourse = arr[0];
            adjList.get(prereq).add(dependentCourse);
        }

       for (int i = 0;i<numCourses;i++){
        if (visited[i] == 0){
            if (hasCycle(i,adjList,visited)) return false;
        }
       }

        return true;
    }

    private boolean hasCycle(int course,HashMap<Integer,List<Integer>> adjList,int[] visited){
        if (visited[course]==1) return true;
        if (visited[course] == 2) return false;

        visited[course] = 1;

        for (int neighbour:adjList.get(course)){
            if (hasCycle(neighbour,adjList,visited))
                return true;
            
        }

        visited[course] = 2;
        return false;
    }
}
