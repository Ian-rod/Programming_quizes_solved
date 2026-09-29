/*
Max Consecutive Ones III

You are given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2

Output: 6
Explanation: The subarray from indices 5 to 10 has 2 zeroes and we can flip them.

Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3

Output: 10
Constraints:

1 <= nums.length <= 100,000
nums[i] is either 0 or 1.
0 <= k <= nums.length

SOLVED USING SLIDING WINDOW
*/

public class MaxOnes {
    public static int longestOnes(int[] nums, int k) {
        int longest1=0;
        int flipLimit=k;
        int left=0; //increase if window is invalid
        int right=0; //increase for more elements

        while (right<nums.length) { 
            for(int i=left;i<=right;i++)
            {
                if(flipLimit==0 && nums[i]==0)
                {
                    //invalid window
                    left++;
                    flipLimit=k;
                    i=left;
                    if(left>=nums.length-1)
                    {
                        return longest1;
                    }
                }
                if(nums[i]==0)
                {
                    flipLimit--;
                }
            }
            if (((right-left)+1)>longest1) {
                longest1=(right-left)+1;
            }
            right++;
            flipLimit=k;
        }
        return longest1;
    }
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1} ,3));
    }
}
