import java.util.*;
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int num:nums)
        {
            int size=res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new  ArrayList<>(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}