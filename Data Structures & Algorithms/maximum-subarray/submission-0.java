class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ubs = -1000000;
        int cb = 0;
        for (int i=0; i<nums.length; i++) {
            int temp = cb + nums[i];
            if (temp > nums[i]) {
                cb = temp;
            } else {
                cb = nums[i];
            }
            if (cb > ubs) {
                ubs = cb;
            }
        }
        return ubs;
    }
}