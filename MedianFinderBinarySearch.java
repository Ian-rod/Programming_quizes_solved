public class MedianFinderBinarySearch {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middle1=0;
        int middle2=0;
        if(nums1.length>nums2.length)
        {
            int temp[]=nums1;
            nums1=nums2;
            nums2=temp;
        }
            middle1=(nums1.length+1)/2;
            middle2=((nums1.length+nums2.length+1)/2)-middle1;

            int l1=nums1[middle1-1];
            int l2=nums1[middle1];
            int r1=nums2[middle2-1];
            int r2=nums2[middle2];
            while (!(l1<=r2&&r1<=l2)) {
                if(l1>r2)
                {
                  middle1--;
                }
                else{
                    middle1++;
                }
                middle2=((nums1.length+nums2.length+1)/2)-middle1;
                 l1=nums1[middle1-1];
                 l2=nums1[middle1];
                 r1=nums2[middle2-1];
                 r2=nums2[middle2];
            }
            if((nums1.length+nums2.length)%2==0)
            {
                return (double)(l1+r1)/2;
            }
            return Double.max(l1, r1);
    }
        public static void main(String[] args) {
          //System.out.println(findMedianSortedArrays(new int[]{ -5, 3, 6, 12, 15 }, new int[]{ -12, -10, -6, -3, 4, 10}));
          System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2,7}));
    }
}
