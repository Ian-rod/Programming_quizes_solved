import java.util.Arrays;

public class SmallestMissingPositive {
    public int firstMissingPositive(int[] nums) {
       Arrays.sort(nums);
       int previous=nums[0];
       for (int i=nums[1];i<nums.length;i++) {
        if(i-previous!=1&& i+previous!=0)
        {
            return previous+1;
        }
        previous=i;
       }

       if(nums[0]-1<=0)
       {
         return nums[nums.length-1]+1; 
       }
       return nums[0]-1; 
    }

    public void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
