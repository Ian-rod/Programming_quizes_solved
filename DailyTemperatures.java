/*
You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.

Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.
*/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int retDays []=new int[temperatures.length];
            int warmdayAwayCount;
        for (int i = 0; i < temperatures.length; i++) {
            warmdayAwayCount=0;
            for (int j = i+1; j < temperatures.length; j++) {
                if(temperatures[i]<temperatures[j])
                {
                    warmdayAwayCount=j-i;
                    break;
                }
            }
            retDays[i]=warmdayAwayCount;
        }
        return retDays;
    }
    public void main(String[] args) {
     System.out.println(dailyTemperatures(new int[]{30,38,30,36,35,40,28}));   
    }
}
