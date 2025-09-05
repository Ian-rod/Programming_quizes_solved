import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MedianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
          List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
          list.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
          Collections.sort(list);
          int length=list.size();
          if(length%2!=0)
          {
                return list.get(length/2);
          }
          int index1=(int)Math.ceil((double)(length-2)/2);
          int index2=(int) Math.ceil((double)(length-1)/2);
          System.out.println(index1);
          System.out.println(index2);
          return (double) (list.get(index1)+list.get(index2))/2;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2,7}));
    }
}
