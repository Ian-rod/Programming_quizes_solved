/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.

The output should not contain any duplicate triplets. You may return the output and the triplets in any order.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Triplets {
   static List<List<Integer>> returnList;
    public static List<List<Integer>> threeSum(int[] nums) {
    List<Integer> numlist = Arrays.stream(nums)
                           .boxed()
                           .collect(Collectors.toList());
    returnList=new ArrayList<List<Integer>>();

    for (int i = 0; i < numlist.size(); i++) {
        ArrayList<Integer> newNumList=new ArrayList<>(numlist);
        ArrayList<Integer> usedList=new ArrayList<>();
        usedList.add(newNumList.get(i));
        newNumList.remove(i);
        genList(newNumList, usedList);
    }
    return returnList;
    }
    public static void genList(List<Integer> numList,List<Integer> usedNumb)
    {
      Collections.sort(usedNumb);

      if(usedNumb.size()==3)
      {
        int total=usedNumb.get(0)+usedNumb.get(1)+usedNumb.get(2);
        if(total==0 && !returnList.contains(usedNumb))
        {
          returnList.add(usedNumb);  
        }
        else{
            return;
        }
      } 

     for (int i = 0; i < numList.size(); i++) {
        ArrayList<Integer> newNumList=new ArrayList<>(numList);
        ArrayList<Integer> usedList=new ArrayList<>(usedNumb);
        usedList.add(newNumList.get(i));
        newNumList.remove(i);
        genList(newNumList, usedList);
    }
    }
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }
}
