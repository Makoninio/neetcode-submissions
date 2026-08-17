class Solution {
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Map storing each course and its prereqs
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Loop to add each course to map
        for (int i=0; i<numCourses; i++) map.put(i, new ArrayList<>());
        // map = {{0, emptlist}, {1, emptylist}, {2, emptylist}, {3, emptylist}, {4, emptylist}}

        // Loop t0 add prereq to each course
        for (int[] prereq : prerequisites) map.get(prereq[0]).add(prereq[1]);
        // map = {{0, {1, 2}}, {1, {3, 4}}, {2, {}}, {3, {4}}, {4, {}} }

        // Perform DFS on each element in the map
        for (int i=0; i<map.size(); i++) {
            if (!dfs(i, map)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int index, HashMap<Integer, List<Integer>> map){
        // {0, {1, 2}}
        // List<Integer> list = path.get(index);
        // {1, 2}

        // Check if already visited
        if (visiting.contains(index)) return false;

        // Base case
        if (map.get(index).isEmpty()) return true;
        
        visiting.add(index);
        for (int neighbour : map.get(index)) {
            if (!dfs(neighbour, map)) {
                return false;
            }
        }
        visiting.remove(index);
        map.put(index, new ArrayList<>());
        return true;
    }
}
//