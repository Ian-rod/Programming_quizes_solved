/*
You are given an integer array nums where each element nums[i] indicates your maximum jump length at that position.

Return true if you can reach the last index starting from index 0, or false otherwise
*/
public class JumpGame {
 public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }
        int end = Math.min(nums.length - 1, i + nums[i]);
        for (int j = i + 1; j <= end; j++) {
            if (dfs(nums, j)) {
                return true;
            }
        }
        return false;
    }

    public void main(String[] args) {
        System.out.println(canJump(new int[]{2,5,0,0}));
    }
}
