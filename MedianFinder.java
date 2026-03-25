import java.util.*;

/*A median Finder */
public class MedianFinder {
    List<Integer> numList;
    public MedianFinder() {
     numList=new ArrayList<>();
    }
    
    public void addNum(int num) {
     numList.add(num);
     Collections.sort(numList);
     System.out.println(numList);
    }    
    public double findMedian() {

       int listLength=numList.size();
       if(listLength%2!=0)
       {
        //its odd
        int medianIndex=((listLength+1)/2);
        return numList.get(medianIndex-1);
       }
        //its even
        int ind1=listLength/2;
        int ind2=ind1+1;
        return (double)(numList.get(ind1-1)+numList.get(ind2-1))/2;
    }

    public  void main(String[] args) {
        MedianFinder med=new MedianFinder();
        med.addNum(1);
        //med.addNum(3);

        med.addNum(2);
        System.out.println(med.findMedian());
    }
}
