/*
 * Given two integers a and b, return the sum of the two integers without using the + and - operators.
 */
public class SumOfTwoIntegers{
    public static int getSum(int a, int b) {
        while(b!=0)
        {
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }
    public static void main(String[] args) {
       System.out.println(getSum(10, 10000)); 
    }
}