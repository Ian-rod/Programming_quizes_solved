import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
    int cycles=0;
    List<Character> taskList=new ArrayList<>();
    //convert tasks to list
    for (char c : tasks) {
        taskList.add(c);
    }
    HashMap<Character,Integer> timeoutMap=new HashMap<>();

    //while list is not empty attempt
    char current='\0';
    int previousCycles=0;
    boolean hasNewAdd=false;
    while(!taskList.isEmpty())
    {
       hasNewAdd=false;
       current=taskList.getFirst();
       previousCycles=cycles;
       if(timeoutMap.containsKey(current))
       {
          if(timeoutMap.get(current)==0)
           {
            //can execute 
            cycles++;
            taskList.remove((Character)current);
            timeoutMap.put(current, n);
            System.out.println("Executed "+current);
            hasNewAdd=true;
           }
           else{
            //get a new current
            for (int i = 1; i < taskList.size(); i++) {
                char possibleCurrent=taskList.get(i);
                if(possibleCurrent!=current)
                {
                    current=possibleCurrent;
                    if(timeoutMap.containsKey(current))
                    {
                        if(timeoutMap.get(current)==0)
                        {
                            cycles++;
                            taskList.remove((Character)current);
                             System.out.println("Executed "+current);
                            timeoutMap.put(current, n);
                            hasNewAdd=true;
                            break;
                        }
                    }
                    else{
                        timeoutMap.put(current, n);
                        hasNewAdd=true;
                        taskList.remove((Character)current);
                        System.out.println("Executed "+current);
                        cycles++;
                        break;
                    }

                }
            }

           }
       }
       else{
        timeoutMap.put(current, n);
        hasNewAdd=true;
        taskList.remove((Character)current);
        System.out.println("Executed "+current);
        cycles++;
       }
       ///Did not find anything to execute
       if(previousCycles==cycles)
       {
          cycles++;
          System.out.println("Added a sleep cycle");
       }
       ///Minus from hashmap timeout
       for (Map.Entry<Character,Integer> m : timeoutMap.entrySet()) {
        if(hasNewAdd && m.getKey().equals(current))
        {
            continue;
        }
        if(m.getValue()>0)
        {
            m.setValue(m.getValue()-1);
        }
       }
        System.out.println(timeoutMap+ "remaining list is "+taskList+" Cycles so far "+cycles);
    }
    //if cannot iterate list looking for sth to execute 
    //Iterate hash map minusing the wait time
      return cycles;        
    }
    public void main(String[] args) {
     // System.out.println(leastInterval(new char[]{'X','X','Y','Y'}, 2)); 
     //System.out.println(leastInterval(new char[]{'A','A','A','B','C'}, 3));
     System.out.println(leastInterval(new char[]{'A','A','A','B','B','B','C','C','C','D','D','E'}, 2));
    }
}
