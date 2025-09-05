public class KokoWithBananas {
     public static int minEatingSpeed(int[] piles, int h) {
        //get max
        int res=0;
        int resMax=0;
        for (int i : piles) {
            if(i>resMax)
            {
                resMax=i;
            }
        }
        res=resMax;
        //apply binary search
        int leftP=1;
        int rightP=resMax;

        int rate=(int)Math.ceil((rightP+leftP)/2);
        while (leftP!=rightP)
        {
            long totalTime=0;
            for (long p : piles) {
               totalTime+=Math.ceil((double)p/rate);
            }
             if (totalTime<=h && rate<res)
            {
                res=rate;
            }
            if (totalTime>h)
            {
              leftP=rate;  
            }
            else{
                rightP=rate; 
            }

            if( rate==(int)Math.ceil((rightP+leftP)/2))
            {
                break;
            }
            rate=(int)Math.ceil((rightP+leftP)/2);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{1,1,1,999999999}, 10));
    }
}
