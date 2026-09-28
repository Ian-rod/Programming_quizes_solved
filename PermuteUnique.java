/*
Permutations II

You are given an array nums, that might contain duplicates , return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]

Output: [
    [1,1,2],
    [1,2,1],
    [2,1,1]
]
Example 2:

Input: nums= [2,2]

Output: [[2,2]]
Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/ 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermuteUnique {
        static List<List<Integer>> res = new ArrayList<>();
        public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> originalNumList=Arrays.stream(nums).boxed().collect(Collectors.toList());
        res.add(originalNumList);

        for(int num:nums)
        {
           List<Integer> usedList=new ArrayList<>(originalNumList);
           usedList.remove((Integer)num);
           generateList(new ArrayList<>(List.of(num)), usedList);
        }

        return res; 
    }

     public static void generateList(List<Integer> genList,List<Integer> usedList)
    {
        if(usedList.isEmpty())
        {
          if(!res.contains(genList))
          {
            res.add(genList);
          }
          return;
        }
        for(int n: usedList)
        {
            List<Integer> newUsed=new ArrayList<>(usedList);
            newUsed.remove((Integer)n);
            List<Integer> newGenList=new ArrayList<>(genList);
            newGenList.add(n);
            generateList(newGenList, newUsed);

        }
    }

    public static void main(String[] args) {
    System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
 
