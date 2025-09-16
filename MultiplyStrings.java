/*
 * You are given two strings num1 and num2 that represent non-negative integers.

Return the product of num1 and num2 in the form of a string.

Assume that neither num1 nor num2 contain any leading zero, unless they are the number 0 itself.

Note: You can not use any built-in library to convert the inputs directly into integers.
 */

import java.util.*;
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if(num1=="0"||num2=="0")
        {
            return "0";
        }

        List<List<Integer>> multiplicationResult=new ArrayList<>();
        int zeros=0;
        //Multiply then add
        for (int i = num2.length()-1; i >= 0; i--) {
        int carry=0;
        List<Integer> singleMultiRes=new ArrayList<>();
        char ZeroConstant='0';
        for (int k = num1.length()-1; k >= 0;k--) {
                int res=((num1.charAt(k)-ZeroConstant)*(num2.charAt(i)-ZeroConstant))+carry;
                int rem=res%10;
                carry= (int) Math.floor(res/10);    
                singleMultiRes.add(0, rem);
                if(k==0 && carry!=0)
                {
                     singleMultiRes.add(0, carry);
                }
        }

           for (int j = 0; j < zeros; j++) {
            singleMultiRes.add(0);
           }
           multiplicationResult.add(singleMultiRes);
           zeros++;
        }

        long returnInt=0;
        for (List<Integer> list : multiplicationResult) {
            long Actualvalue=1;
            for (int i = list.size()-1; i >=0 ; i--) {
                long value=list.get(i)*Actualvalue;
                Actualvalue*=10;
                returnInt+=value;
            }
        }
        return String.valueOf(returnInt);
    } 
    public static void main(String[] args) {
        System.out.println(multiply("123456789", "987654321"));
    }
}
