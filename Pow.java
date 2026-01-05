public class Pow {
    public static double myPow(double x, int n) {
        double sol=1;
        //to flip the bits incase of a negative number
        if(n<0)
        {
            x=1/x;
            n*=-1;
        }
       for (int i = 0; i < n; i++) {
        sol=sol*x;
       } 
       return sol;
    }
    public static void main(String[] args) {
        System.out.println(myPow(2, -3));
    }
}
