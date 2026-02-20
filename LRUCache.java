/*

Implement the Least Recently Used (LRU) cache class LRUCache. The class should support the following operations

LRUCache(int capacity) Initialize the LRU cache of size capacity.
int get(int key) Return the value corresponding to the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the introduction of the new pair causes the cache to exceed its capacity, remove the least recently used key.
A key is considered used if a get or a put operation is called on it.

Ensure that get and put each run in 
O
(
1
)
O(1) average time complexity.*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LRUCache {
    int cacheCapacity=0;
    List<Map.Entry<Integer,Integer> > cache;
    public LRUCache() {
    }
    
    public LRUCache(int capacity) {
        cacheCapacity=capacity;
        cache=new ArrayList<Map.Entry<Integer,Integer> >();
    }
    
    public int get(int key) {
        int cacheCurrentSize=cache.size();
        ///The one at the front is the least used
        for (int i=0;i<cacheCurrentSize;i++) {
            if(cache.get(i).getKey()==key)
            {
               Map.Entry<Integer,Integer> actedmap= cache.get(i);
               cache.remove(i);
               cache.add(0, actedmap);
               return actedmap.getValue();
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        int cacheCurrentSize=cache.size();
        for (int i=0;i<cacheCurrentSize;i++) {
             if(cache.get(i).getKey()==key)
            {
               cache.remove(i);
               cache.add(0, Map.entry(key, value));
               return;
            }
        }

        if(cache.size()==cacheCapacity)
        {
          cache.remove(cacheCapacity-1);
        }

        cache.add(0,Map.entry(key, value));
    }
    public void main(String[] args) {
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1);  // cache: {1=10}
          lRUCache.put(2, 2);  
          lRUCache.put(3, 3);  
          lRUCache.get(1);  
          lRUCache.get(2);
          lRUCache.get(4);
           lRUCache.put(4, 4); 
          lRUCache.get(1);  
          lRUCache.get(2);
           lRUCache.get(3);
           lRUCache.get(4);
             lRUCache.get(2);
             lRUCache.put(1, 8); 
             lRUCache.put(3, 7);  
    //     lRUCache.put(3, 3); 
    //  System.out.println(lRUCache.get(2));      // return 10
        // lRUCache.put(2, 20);  // cache: {1=10, 2=20}
        // lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
        // System.out.println(lRUCache.get(2));;      // returns 20 
        // lRUCache.get(1);      // return -1 (not found)
    }
}
