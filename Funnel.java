import java.util.ArrayList;

class Funnel {
    ArrayList<Character> funnelComponents=new ArrayList<>();
    public Funnel() {
    
    }
    
    public void fill(char...args) {
       for (char c : args) {
        if(funnelComponents.size()==15)
        {
            break;
        }
        funnelComponents.add(c);
       }
    }
    
    public Character drip() {
        if(funnelComponents.isEmpty())
        {
            return null;
        }
        char returnChar= funnelComponents.get(0);
        funnelComponents.remove(0);
        return returnChar;
    }
    
    @Override
    public String toString() {
        String funnelState= "\\         /\n" +
                            " \\       /\n" +
                            "  \\     /\n" +
                            "   \\   /\n" +
                            "    \\ /";
        //Empty funnel      
       if (funnelComponents.size()>0)
       {
        funnelState="";
        int characterTracking=0;
        int spaceTracking=5;
        for (int i = 0; i < 5; i++) {
            String funnelRow="\\";
            for (int j = 0; j < spaceTracking+1; j++) {
                funnelRow=" "+ funnelRow;
            }
            for(int l=0;l<i+1;l++)
            {
               char CharInsert=' ';

            if(characterTracking<funnelComponents.size())
            {
                CharInsert=funnelComponents.get(characterTracking);
                characterTracking++;
            }
                //Insert Numbers
                funnelRow+=CharInsert+" ";
            }
            //Remove one trailing space
            if (funnelRow.endsWith(" "))
            {
               funnelRow= funnelRow.substring(0, funnelRow.length()-1);
            }
            funnelRow=funnelRow+"/"+"\n";
            funnelState=funnelRow+funnelState;
            spaceTracking--;
        }
       }
        return funnelState.stripTrailing();
    }
    public static void main(String[] args) {
         Funnel funnel = new Funnel();
         funnel.fill('1','2','3');
         funnel.drip();
         System.out.println(funnel);
    }
}