import java.util.*;
/*
 * You are given a string digits made up of digits from 2 through 9 inclusive.

Each digit (not including 1) is mapped to a set of characters as shown below:

A digit could represent any one of the characters it maps to.

Return all possible letter combinations that digits could represent. You may return the answer in any order.
 */
public class PhoneNumberLetters {
    public static List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        Map<Character,List<String>> phoneLetterMapping =Map.of(
            '2', List.of("a","b","c"),
              '3', List.of("d","e","f"),
                '4', List.of("g","h","i"),
                  '5', List.of("j","k","l"),
                    '6', List.of("m","n","o"),
                      '7', List.of("p","q","r","s"),
                        '8', List.of("t","u","v"),
                          '9', List.of("w","x","y","z")
        
        );

        if(digits.length()==0)
        {
          return result;
        }

        List<List<String>> chars=new ArrayList<>();
        for (char c : digits.toCharArray()) {
            chars.add(phoneLetterMapping.get(c));         
        }
        
        result=chars.get(0);
        for (int i = 1; i < chars.size(); i++) {
            result=generateCombinations(result, chars.get(i));
        }
        return result;
    }

    public static List<String> generateCombinations(List<String> a,List<String> b)
    {
      List<String> result=new ArrayList<>();
       for (int i = 0; i < a.size(); i++) {
          for (int j = 0; j < b.size(); j++) {
            result.add(a.get(i)+b.get(j));
          }
       }
       return result;
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}