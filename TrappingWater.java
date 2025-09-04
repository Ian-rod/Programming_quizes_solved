public class TrappingWater{
    public static int trap(int[] height) {
        int result=0;
        if (height==null || height.length==0)
        {
            return 0;
        }
        for (int i=0;i<height.length;i++) {
            int leftMax=height[i];
            int rightMax=height[i];

            for(int j=0;j<i;j++)
            {
                leftMax=Math.max(leftMax, height[j]);
            }
            for(int l=i+1;l<height.length;l++)
            {
                rightMax=Math.max(rightMax, height[l]);
            }
            
            result+=Math.min(leftMax, rightMax)-height[i];
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(TrappingWater.trap(new int[]{0,2,0,3,1,0,1,3,2,1}));
    }
}