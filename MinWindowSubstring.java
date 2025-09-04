import java.util.*;
public class MinWindowSubstring {

    public static String minWindow(String s, String t)
    {

        String result="";
        char[] tArr=t.toCharArray();
        ArrayList<Character> matchTracker=new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
          if(t.contains(String.valueOf(s.charAt(i))))
          {
                //Begin inner loop
                String subString="";
                for (int j = i; j < s.length(); j++) {
                    subString+=String.valueOf(s.charAt(j));
                    matchTracker.clear();
                    String tempSubString=subString;
                    for (int l = 0; l < tArr.length; l++) {
                        if(tempSubString.contains(String.valueOf(tArr[l])))
                        {
                            tempSubString=tempSubString.replaceFirst(String.valueOf(tArr[l]), "");
                            matchTracker.add(tArr[l]);
                        }
                    }
                    if(matchTracker.size()==t.length())
                    {
                        if(result.isEmpty()||result.length()>subString.length())
                        {
                            result=subString;
                        }    
                       
                    }
                }
          }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(minWindow("aa", "aa"));
    }
}