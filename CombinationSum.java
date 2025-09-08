import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
     static List<List<Integer>> res=new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] nums, int target) {   

      for (int i = 0; i < nums.length; i++) {
        List<Integer> pos=new ArrayList<>();
        if(nums[i]<=target)
        {
           pos.add(nums[i]);
           sumList(nums, target, pos,nums[i]);
        }
      }

      return res;
    }

    public static void sumList(int[] nums, int target,List<Integer> resIntegers,int total)
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

            for(int n:nums)
            {
                if(n+total<=target)
                {
                    List<Integer> myIntegers=new ArrayList<>(resIntegers);
                    myIntegers.add(n);
                    sumList(nums, target,myIntegers ,total+n);
                }
                else{
                    continue;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{3}, 16));
    }
}