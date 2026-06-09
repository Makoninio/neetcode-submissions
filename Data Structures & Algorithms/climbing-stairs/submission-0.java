class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dpArray = new int[n + 1];
        dpArray[1] = 1;
        dpArray[2] = 2;
        for (int i=3; i<=n; i++) {
            dpArray[i] = dpArray[i -1] + dpArray[i-2];
        }
        return dpArray[n];
    }
}
