class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        dfs(nums, permutation, result, seen);
        return result;
    }

    private void dfs(int[] nums, List<Integer> permutation, List<List<Integer>> result, boolean[] seen) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (!seen[i]) {
                permutation.add(nums[i]);
                seen[i] = true;
                dfs(nums, permutation, result, seen);
                permutation.remove(permutation.size() - 1);
                seen[i] = false;
            }
        }
       



    }
}
