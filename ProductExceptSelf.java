public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {

        if(nums.length==1)
        {
            return new int[]{nums[0]};
        }

        int[] resultProd=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product=1;
            for(int j=0;j<nums.length;j++)
            {
                if(i==j)
                {
                    continue;
                }
                product*=nums[j];
            }
            System.out.println(product);
            resultProd[i]=product;
        }
        return resultProd;
    }
    public static void main(String[] args) {
        ProductExceptSelf.productExceptSelf(new int[]{0});
    }
}
