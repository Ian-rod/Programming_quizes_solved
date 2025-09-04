///Solution error

public class Dictionary {
  
  private final String[] words;

  public Dictionary(String[] words) {
    this.words = words;
  }
  
  public String findMostSimilar(String to) {
    //Metrics For every Character present + , Not present - ...Highest Wins
    //To Increase Match Likelyhood ie in negative scenarios
    int matchLikelyHood=0-to.length();
    String matchword="";
    for (String w : words) {
        char[] wchar=w.toCharArray();
        int wcharLikelyHood=0;
        String toCopy=to;
        for (char c : wchar) {
            String cString=String.valueOf(c);
            if(toCopy.contains(cString))
            {
                wcharLikelyHood++;
                toCopy=toCopy.replaceFirst(cString,"");
            }
            else{
               wcharLikelyHood--; 
            }
        }
        System.out.println(w+" "+wcharLikelyHood);
        if (wcharLikelyHood>matchLikelyHood)
        {
           matchLikelyHood=wcharLikelyHood;
           matchword=w; 
        }
    }
    return matchword;
  }
  public static void main(String[] args) {
     Dictionary dictionary = new Dictionary(new String[]{"psaysnhfrrqgxwik", "pdyjrkaylryr", "lnjhrzfrosinb", "afirbipbmkamjzw", "loogviwcojxgvi", "iqkyztorburjgiudi", "cwhyyzaorpvtnlfr", "iroezmixmberfr", "jhjyasikwyufr", "tklquxrnhfiggb", "cpnqknjyviusknmte", "hwzsemiqxjwfk", "ntwmwwmicnjvhtt", "emvquxrvvlvwvsi", "sefsknopiffajor", "znystgvifufptxr", "xuwahveztwoor", "hrwuhmtxxvmygb", "karpscdigdvucfr", "xrgdgqfrldwk", "nnsoamjkrzgldi", "ljxzjjorwgb", "cfvruditwcxr", "eglanhfredaykxr", "fxjskybblljqr", "qifwqgdsijibor", "xikoctmrhpvi", "ajacizfrgxfumzpvi", "mhmkakybpczjbb", "vkholxrvjwisrk", "npyrgrpbdfqhhncdi", "pxyousorusjxxbt", "jcocndjkyb", "fxpvfhfrujjaifr", "hkldhadcxrjbmkmcdi", "hirldidcuzbyb", "ggcvrtxrtnafw", "tdvibqccxr", "osbednerciaai", "qojfrlhufr", "kqijoorfkejdcxr", "zqdrhpviqslik", "clxmqmiycvidiyr", "xffrkbdyjveb", "dyhxgviphoptak", "dihhiczkdwiofpr", "riyhpvimgaliuxr", "fgtrjakzlnaebxr", "ppctybxgtleipb", "ucxmdeudiycokfnb"});
     System.out.println( dictionary.findMostSimilar("rkacypviuburk"));
  }
}