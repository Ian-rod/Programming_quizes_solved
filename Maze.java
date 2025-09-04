import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Maze {
    
    public static ArrayList<String> VisitedNodes=new ArrayList<>(); 
    public static boolean DetectWinOrMakeMove(int rowPos,int columnPos,char [][] mazeIn2D,int rowCount)
    {
        String nodeInCoordinate=String.format("%d\n%d",rowPos,columnPos);
        if ( Maze.VisitedNodes.contains(nodeInCoordinate))
        {
           return false;
        }

        Maze.VisitedNodes.add(nodeInCoordinate);
        System.out.println(String.format("K position is %d,%d the rowlength is %d",rowPos,columnPos,mazeIn2D[rowPos].length));
        ArrayList<String> possibleMoves=new ArrayList<>(); 
        if (rowPos==0 ||columnPos==0 ||rowPos==rowCount-1){
            //One case is missing, added in next if 
            System.out.println("Returned true at Exit One " +String.format("%d,%d",rowPos,columnPos));  
            return true;
        }

        if (mazeIn2D[rowPos].length==(columnPos+1))
        {
            System.out.println("Returned true at Exit Two " +String.format("%d,%d",rowPos,columnPos));            
            return true;
        }

        try {
        //Check if can move left
        if (mazeIn2D[rowPos-1][columnPos]!='#')
        {
            possibleMoves.add(String.format("%d\n%d",rowPos-1,columnPos));
        }  
        } catch (Exception e) {
           //Cannot move left
        }

        try {
           //Check if can move down
            if (mazeIn2D[rowPos+1][columnPos]!='#')
            {
                possibleMoves.add(String.format("%d\n%d",rowPos+1,columnPos));
            }    
        } catch (Exception e) {
            //Not possible to move down
        }


        //Check if can move up
       if (mazeIn2D[rowPos][columnPos-1]!='#')
        {
            possibleMoves.add(String.format("%d\n%d",rowPos,columnPos-1));
        }

          //Check if can move right
         if (mazeIn2D[rowPos][columnPos+1]!='#')
        {
            possibleMoves.add(String.format("%d\n%d",rowPos,columnPos+1));
        }
 
       for (String move : possibleMoves) {
        Scanner moveScanner=new Scanner(move);
        int newRowPos= moveScanner.nextInt();
        int newColPos= moveScanner.nextInt();
       if(Maze.DetectWinOrMakeMove(newRowPos, newColPos, mazeIn2D, rowCount)){
            moveScanner.close();
            return true;
       }
        moveScanner.close();
       }

        return false;
    }

    public static boolean hasExit(String[] maze) {
        // If more than One K return false
        Maze.VisitedNodes.clear();
        String mazeJoined=String.join("", maze);
        Pattern kPattern=Pattern.compile("k");
        Matcher matcher=kPattern.matcher(mazeJoined);
        if (matcher.results().count()!=1)
        {
             throw new RuntimeException("Multiple Kates!!");
        }

      //Position Of K
      int rowPos=0;
      int columnPos=0;

     //maze into 2D array and detect position of K
      int rowCount=maze.length;
      char [][] mazeIn2D=new char[1000][1000];
      int longestRow=0;
      for (int i = 0; i < rowCount; i++) {
        if (maze[i].length()>longestRow)
        {
            longestRow=maze[i].length();
        }
      }

      for (int i = 0; i < rowCount; i++) {
          System.out.println( maze[i]);
          maze[i]=String.format("%-" + longestRow + "s",  maze[i]);      
          mazeIn2D[i]=maze[i].toCharArray();
          if (maze[i].contains("k"))
          {
            rowPos=i;
            columnPos=maze[i].indexOf("k");
          }
      }
     // Throw a RuntimeException if needed.
        return DetectWinOrMakeMove(rowPos,columnPos,mazeIn2D,rowCount);
    }

    public static void main(String[] args) {
        System.out.println(Maze.hasExit( new String[] 
                            { 
                                "#########",
                                "#k        #",
                                "###########"
                            }));
                             }
}