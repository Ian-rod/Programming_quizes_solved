public class LIS {

    public static int minDeletions(int[] nums)
    {
        int LIDLength=0;
        //get LIS n-LIS = deletions
        int[] tempNums=new int[nums.length];
        //populate temp nums
        for (int i =0;i<nums.length;i++) {
             tempNums[i]=1;
        }

        //begin
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {   
                if(nums[i]>nums[j])
                {
                   int newi=tempNums[j]+1;

                   if(newi>tempNums[i])
                   {
                    tempNums[i]=newi;
                   }

                    if (tempNums[i]>LIDLength)
                    {
                        LIDLength=tempNums[i];
                    }
                }
            }
        }

        return nums.length-LIDLength;
    }
    
public static void main(String[] args) {

    System.out.println(LIS.minDeletions(new int[]{5, 3, 4, 2, 6}));
}
}