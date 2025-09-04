public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int result=0;
        int beginSubIndex=0;
       for(int i=0;i<=s.length();i++)
        {
            String subS=s.substring(beginSubIndex, i);
            char subSArr[]=subS.toCharArray();
            int mostFreqCount=0;
            //get the most frequent occuring char
            for (char c : subSArr) {
            int freq=0;
            for(int j=0;j<subSArr.length;j++)
            {
                if(subSArr[j]==c){
                  freq++;
                }
            }
                if(freq>mostFreqCount)
                {
                    mostFreqCount=freq;
                }
            }

            if(subS.length()-mostFreqCount<=k)
            {
                result=subS.length();
            }
            else{
                beginSubIndex++;
            }
        }
     
        return result;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AAAAABBBBCBB", 0));
    }
}
