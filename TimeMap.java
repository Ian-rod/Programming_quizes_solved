import java.util.*;
public class TimeMap {
    TreeMap <Integer,HashMap<String,String>> myTimeMap;
    public TimeMap() {
        myTimeMap=new TreeMap<>(Collections.reverseOrder());
    }
    
    public void set(String key, String value, int timestamp) {
        myTimeMap.put(timestamp,new HashMap<String,String>(){{put(key,value);}});
    }
    
    public String get(String key, int timestamp) {
        if(myTimeMap.containsKey(timestamp))
        {
            return myTimeMap.get(timestamp).get(key);
        }

        for(Map.Entry<Integer,HashMap<String,String>> e:myTimeMap.entrySet())
        {
           if(e.getValue().get(key)!=null)
           {
            if (e.getKey()>timestamp)
            {
                continue;
            }
            return e.getValue().get(key);
           }
        }

       return ""; 
    }
    public static void main(String[] args) {
      TimeMap timeMap = new TimeMap();  
      timeMap.set("alice", "happy", 1); 
      timeMap.set("alice", "sad", 3);
      System.out.println(timeMap.get("alice", 3)); 

    }
}
