/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {
    List<List<Integer>> resultList=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {

        ///nums to list
        List<Integer> numList = Arrays.stream(nums)
                                          .boxed()
                                          .collect(Collectors.toList());
        ///Have 2 lists used and unused
        for (int n : nums) {
            List<Integer> usedIntegers=Arrays.asList(n);
            List <Integer> unUsedIntegers=new ArrayList<>(numList);
            unUsedIntegers.remove((Integer)n);
            recursiveAdd(usedIntegers, unUsedIntegers);
             
        }
        /// once used move it to unused
        /// if used sum=0 add to main list
        /// return main List
        return resultList;
    }
    public void recursiveAdd(List<Integer> usedIntegers,List<Integer> unUsedIntegers)
    {
       if(usedIntegers.size()==3)
        {
            int sum=0;
            for (Integer i : usedIntegers) {
              sum+=i;  
            }
            Collections.sort(usedIntegers);
            if(sum==0 && !resultList.contains(usedIntegers))
            {
                resultList.add(usedIntegers);
            }
            return;
        } 

        for (Integer num : unUsedIntegers) {
            List<Integer> newUsedIntegers=new ArrayList<>(usedIntegers);
            newUsedIntegers.add(num);
            List <Integer> newUnUsedIntegers=new ArrayList<>(unUsedIntegers);
            newUnUsedIntegers.remove((Integer)num);
            recursiveAdd(newUsedIntegers, newUnUsedIntegers);
        }
    }
    /*
    0(n3)
    */
    public List<List<Integer>> threeSumv2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        List<Integer> result=Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(result);
                        if(!resultList.contains(result))
                        {
                            resultList.add(result);
                        }
                    }
                }
            }    
        }

      return resultList;  
    }
    public  void main(String[] args) {
       // System.out.println(threeSum(new int[]{14,4,6,-1,10,9,-8,7,-13,14,-13,-11,-8,-9,11,14,-8,-14,-13,7,-10,-15,-13,-11,-11,11,14,13,2,-14,1,-7,-2,14,-1,-15,9,7,-1,3,6,1,7,5,-1,-5,4,-2,-4,-1,-9,-7,-1,-7,-11,3,12,10,-7,-1,12,1,8,-13,1,14,9,-13,6,-7,-3,-11,2,-11,10,-14,-1,-9,0,2,5,6,3,-11,6,7,0,3,3,0,-12,-8,-13,3,-14,-5,2,10,-11,-14,-12,1,-10,5,5,7,-1,11,14,6,-10,-4,-3,8,-7,10,1,8,-1,-11,-15,-6,-12,-13,12,-11}));
          System.out.println(threeSumv2(new int[]{14,4,6,-1,10,9,-8,7,-13,14,-13,-11,-8,-9,11,14,-8,-14,-13,7,-10,-15,-13,-11,-11,11,14,13,2,-14,1,-7,-2,14,-1,-15,9,7,-1,3,6,1,7,5,-1,-5,4,-2,-4,-1,-9,-7,-1,-7,-11,3,12,10,-7,-1,12,1,8,-13,1,14,9,-13,6,-7,-3,-11,2,-11,10,-14,-1,-9,0,2,5,6,3,-11,6,7,0,3,3,0,-12,-8,-13,3,-14,-5,2,10,-11,-14,-12,1,-10,5,5,7,-1,11,14,6,-10,-4,-3,8,-7,10,1,8,-1,-11,-15,-6,-12,-13,12,-11}));
    }
}
