/*
You are given two strings s1 and s2.

Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.

Both strings only contain lowercase letters.

*/

public class PermutationString {
    public static boolean checkInclusion(String s1, String s2) {
        int left=0;
        String s1clone=s1;
        while(!s1clone.isEmpty())
        {
            for (int l = left; l < s2.length(); l++) {
                if(s1clone.contains(String.valueOf(s2.charAt(l))))
                {
                    s1clone=s1clone.replaceFirst(String.valueOf(s2.charAt(l)),"");
                    if(s1clone.isEmpty())
                    {
                        return true;
                    }
                    System.out.println(s1clone);
                }
            else{
               break;
            }
                System.out.println(s1clone);
            }
            left++; 
            s1clone=s1;
            System.out.println("Reset left at "+left);
            if(left>=s2.length())
            {
                break;
            }
           
        }     
        return false;
    }
    public static void main(String[] args) {
        System.out.println(checkInclusion("aabb", "abcaab"));
    }
}
