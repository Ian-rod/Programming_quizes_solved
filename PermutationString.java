import java.util.*;
/*
You are given two strings s1 and s2.

Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.

Both strings only contain lowercase letters.

*/

public class PermutationString {
    int requiredLength=0;
    List<String> permutationList=new ArrayList<>();
     public boolean checkInclusion(String s1, String s2) {
        requiredLength=s1.length();
        List<String> s1Chars=new ArrayList<>();
       //Build all possible permutations from s1
        for (char c : s1.toCharArray()) {
            s1Chars.add(String.valueOf(c));
        }

        for (int i = 0; i < s1Chars.size(); i++) {
            List<String> newS1chars=new ArrayList<>(s1Chars);
            newS1chars.remove(i);
            permute(s1Chars.get(i), newS1chars);
        }

        System.out.println(permutationList);
        //check if s2 contains anything from the list
        for (String p : permutationList) {
            if(s2.contains(p))
            {
                return true;
            }
        }     
        return false;
    }
    public void permute(String currString,List<String> unused)
    {
        if(currString.length()==requiredLength)
        {
            if(!permutationList.contains(currString))
            {
                permutationList.add(currString);
                System.out.println(currString);
            }
            return;
        }

        for (int i = 0; i < unused.size(); i++) {
          String newcurrString=currString+unused.get(i);
           List<String> newUnused=new ArrayList<>(unused);
           newUnused.remove(i);
           permute(newcurrString, newUnused);
        }
    }
    public void main(String[] args) {
        System.out.println(checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
    }
}
