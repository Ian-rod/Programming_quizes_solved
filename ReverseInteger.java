/*
 * You are given a signed 32-bit integer x.

Return x after reversing each of its digits. After reversing, if x goes outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0 instead.

Solve the problem without using integers that are outside the signed 32-bit integer range.
 */

public class ReverseInteger {
    public  static int reverse(int x) {
      boolean isNegative=x<0;
      String xString=String.valueOf(x);
      if(isNegative)
      {
        xString=xString.replace("-", "");
      }

      StringBuilder sbStr = new StringBuilder(xString);
      String reversedX=isNegative?"-"+sbStr.reverse().toString():sbStr.reverse().toString();
      int returnInt=0;
      try {
        returnInt=Integer.parseInt(reversedX);
      } catch (Exception e) {
      }
      
     return returnInt;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }
}
