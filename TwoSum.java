/*
Given an array of integers numbers that is sorted in non-decreasing order.

Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.

There will always be exactly one valid solution.

Your solution must use 
O
(
1
)
O(1) additional space.
*/
public class TwoSum {
        public int[] twoSum(int[] numbers, int target) {
        for (int i=0;i<numbers.length;i++)
        {
            for (int j=i+1;j<numbers.length;j++)
            {
                if(numbers[i]+numbers[j]==target)
                {
                    return new int[]{i+1,j+1};
                }
            }
        }
        return null;
    }
}
