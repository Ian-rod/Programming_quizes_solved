import java.util.HashSet;

public class LengthOfLongestSub {
    public static int lengthOfLongestSubstring(String s) {
     if (s.length()<=1)
     {
        return s.length();
     }  
     int result=0;
     HashSet<Character> mySet=new HashSet<>();
     for (int i = 0; i < s.length(); i++) {
        mySet.clear();
        for (int j = i; j < s.length(); j++) {
            if(!mySet.contains(s.charAt(j)))
            {
                mySet.add(s.charAt(j));
            }
            else{
                break;
            }
        }
        result=Math.max(result, mySet.size());
     }
     return result;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
