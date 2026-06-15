class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int i =0;i<n;i++){
            if (!visited.contains(i)){
                count++;
                dfs(i,adjList,visited);
            }
        }
        return count;
    }

    private void dfs(int node,List<List<Integer>> adjList,HashSet<Integer> visited){
        if (visited.contains(node)) return;

        visited.add(node);

        for (int neighbor:adjList.get(node))
            dfs(neighbor,adjList,visited);
    }
}
