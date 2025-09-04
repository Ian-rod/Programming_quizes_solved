import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
        public int[] topKFrequent(int[] nums, int k) {
        int[] mostFreqElements=new int[k];
        ArrayList<Integer> numsArrGrps=new ArrayList<>();
        //Build groups
        for (int i : nums) {
           if(!numsArrGrps.contains(i))
           {
                numsArrGrps.add(i);
           } 
        }

        HashMap<Integer, Integer> numFreqMap = new HashMap<Integer, Integer>();
        //Count down the frequency
        for (int i : numsArrGrps) {
            int freq=0;
            for (Integer j : nums) {
                if (i==j)
                {
                   freq++;
                }
            }
            numFreqMap.put(i, freq);
        }

        List<Map.Entry<Integer,Integer>> sortedlist=new ArrayList<>(numFreqMap.entrySet());
        sortedlist.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
       
        for(int i=0;i<k;i++)
        {
         mostFreqElements[i]=sortedlist.get(i).getKey();
        }

        return mostFreqElements;
       }
}
