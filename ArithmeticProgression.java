import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/*
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.



*/
public class ArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        //Normal order
        if(arr.length==2)
        {
            return  true;
        }
      Integer[] arr2= IntStream.of(arr).boxed().toArray(Integer[]::new);
       Arrays.sort(arr); 
      if( check(arr2))
      {
        return true;
      }
        //reverse the order
       Arrays.sort(arr2,Collections.reverseOrder()); 

       return check(arr2);
    }

    public boolean check(Integer arr[])
    {
        for (int i = 0; i< arr.length-2; i++) {
          if(arr[i]-arr[i+1]==arr[i+1]-arr[i+2])
            {
                return true;
            }  
        }
        return false;
    }

    public void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{13,12,-12,9,9,16,7,-10,-20,0,18,-1,-20,-10,-8,15,15,16,2,15}));
    }
}
