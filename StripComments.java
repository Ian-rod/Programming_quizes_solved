import java.util.*;
public class StripComments {

	public static String stripComments(String text, String[] commentSymbols) {
     Scanner txtScanner=new Scanner(text);
     String lineTxt="";
     String retStr="";
     while(txtScanner.hasNext())
     {
       lineTxt=txtScanner.nextLine();
       for (String c : commentSymbols) {
        if(lineTxt.contains(c))
        {
            int indexOfC=lineTxt.indexOf(c);
            String subRetString=lineTxt.substring(0, indexOfC);
            lineTxt=subRetString;         
        }
       }
       if(txtScanner.hasNext())
       {
            retStr+=lineTxt.stripTrailing()+"\n";
       }
       else{
         retStr+=lineTxt.stripTrailing();
       }
     }
    txtScanner.close();
	return retStr;
	}
	
    public static void main(String[] args) {
        System.out.println(  StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" }) );
    }
}
