public class SlidingWindowMaximum {
    public  static int[] maxSlidingWindow(int[] nums, int k) {
       int[] maxArr=new int[nums.length-k+1];
       for (int i = 0; i < nums.length-k+1; i++) {
        int maxelement=-1000;
        for (int j = i; j< nums.length; j++) {
            if(j-i==k)
            {
                break;
            }
            if(nums[j]>maxelement)
            {
                maxelement=nums[j];
            }
        }
        maxArr[i]=maxelement;
        System.out.println(maxelement);
       } 
       return maxArr;
    }
    public static void main(String[] args) {
       SlidingWindowMaximum.maxSlidingWindow(new int[]{1,2,1,0,4,2,6}, 3) ;
    }
}
