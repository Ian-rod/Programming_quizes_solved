import java.util.*;
/*
 * You are given an array of integers candidates, which may contain duplicates, and a target integer target. Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.

Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.

You may return the combinations in any order and the order of the numbers in each combination can be in any order.
 */
public class UniqueCombinationSum {
 static List<List<Integer>> res=new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {   
      for (int i = 0; i < nums.length; i++) {
        List<Integer> pos=new ArrayList<>();
        List<Integer> usedIndices=new ArrayList<>();
        if(nums[i]<=target)
        {
           pos.add(nums[i]);
           usedIndices.add(i);
           sumList(nums, target, pos,nums[i],usedIndices);
        }
      }

      return res;
    }

    public static void sumList(int[] nums, int target,List<Integer> resIntegers,int total,List<Integer> usedIndices)
    {
        if(total==target)
        {
            Collections.sort(resIntegers);
            if(!res.contains(resIntegers))
            {
                 res.add(resIntegers);    
            }
       
        }
        else if(total<target)
        {

            for(int i = 0; i < nums.length; i++)
            {
                if((nums[i]+total<=target) && !usedIndices.contains(i))
                {
                    List<Integer> myIntegers=new ArrayList<>(resIntegers);
                    myIntegers.add(nums[i]);
                    usedIndices.add(i);
                    sumList(nums, target,myIntegers ,total+nums[i],usedIndices);
                }
                else{
                    continue;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1,2,3,4,5}, 7));
    }
}