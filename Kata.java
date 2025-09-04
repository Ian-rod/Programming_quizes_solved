import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata {
  
  public static boolean isAValidMessage(String message) {
    //Format text
    String [] messageSplited= message.split("[0-9]+");
    String [] numbersSplited= message.split("[a-zA-z]+"); 

    if (message.isEmpty() ||message=="0")
    {
      return true;
    }
    Pattern msgPattern=Pattern.compile("([0-9]+[a-zA-Z]*)+");
    Matcher msgMatcher=msgPattern.matcher(message);
    if (!msgMatcher.find())
    {
        return false;
    }

    if (messageSplited.length-1!=numbersSplited.length)
    {
      return false;
    }
    for (int i=0;i<numbersSplited.length;i++) {
      int length=Integer.valueOf(numbersSplited[i]);

      if(messageSplited[i+1].length()!=length)
      {
          return false;
      }
    }
     return true;
  }

  public static void main(String[] args) {
   System.out.println( Kata.isAValidMessage("zqETPpnlNOSiXWRJpWcxLPNjdReyUhZVDuwTefJxHQHbbZZURsbgT"));
  }
}