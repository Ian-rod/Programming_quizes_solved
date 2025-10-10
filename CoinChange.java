import java.util.*;
/*
 * You are given an integer array coins representing coins of different denominations (e.g. 1 dollar, 5 dollars, etc) and an integer amount representing a target amount of money.

Return the number of distinct combinations that total up to amount. If it's impossible to make up the amount, return 0.

You may assume that you have an unlimited number of each coin and that each value in coins is unique.
 */

public class CoinChange {
    public static  List<List <Integer>> posibilitiesUsed=new ArrayList<>();
    public static int change( int amount,int[] coins) {
    int totalCombinations=0;
    for (int i : coins) {
        totalCombinations+=change(coins, amount,Arrays.asList(i));
    }
    System.out.println("The posibilities used are "+posibilitiesUsed);
    return totalCombinations;
    }
    public static int change(int[] nums, int target,List<Integer> usedIntegers) 
    {
        int combinations=0;
        //check temp target
        int tempTarget=0;
        for (Integer i : usedIntegers) {
            tempTarget+=i;
        }
        Collections.sort(usedIntegers);
        if((tempTarget==target)&&!posibilitiesUsed.contains(usedIntegers))
        {
            posibilitiesUsed.add(usedIntegers);
            return 1;
        }
        
        for (int i : nums) {
        if(tempTarget<target)
        {
            tempTarget+=i;
            List <Integer> newUsedIntegers=new ArrayList<>(usedIntegers);
            newUsedIntegers.add(i);
            combinations+=change(nums, target,newUsedIntegers);
        }
    } 
    return combinations;
    }
    public static void main(String[] args) {
        System.out.println(change( 5,new int[]{2,5}));
    }
}
