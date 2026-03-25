import java.util.*;
//done by coding the fomular
//cycles=max(total tasks, (maxFreq−1)(n+1)+countMax)
public class TaskSchedulerV2 {
     public int leastInterval(char[] tasks, int n) {
        //get maxfreq,get count max
        //Create a hashmap for later reference 
        HashMap<Character,Integer> elementCount=new HashMap<>();

        //getting the max frequency
        int maxfreq=0;
        for (char c : tasks) {
            int newCount= 1;
            if(elementCount.containsKey(c))
            {
                newCount= elementCount.get(c)+newCount;
            }
            elementCount.put(c, newCount);
            if(newCount>maxfreq)
            {
                maxfreq=newCount;
            }
        }

        //Getting the count max
        int countMax=0;
        for (Map.Entry<Character,Integer> m : elementCount.entrySet()) {
            if(m.getValue()==maxfreq)
            {
                countMax++;
            }
        }

        return Integer.max(tasks.length, (maxfreq-1)*(n+1)+countMax);
     }

     public void main(String[] args) {
          System.out.println(leastInterval(new char[]{'A','A','A','B','B','B','C','C','C','D','D','E'}, 2));
     }
}
