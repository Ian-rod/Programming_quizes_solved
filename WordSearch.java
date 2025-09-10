
/*
 * Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.

For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
       
        for (int c = 0; c < board.length; c++) {
            for (int r = 0;  r < board[c].length; r++) {
               if(board[c][r]==word.charAt(0))
               {
                if(word.length()==1)
                {
                    return true;
                }
                    if(checkMode(c,r, board,1,word,new ArrayList<>(Arrays.asList(String.join(":", String.valueOf(c),String.valueOf(r))))))
                    {
                          return true;
                    } 

               }
            }
        }
        return false;
    }

    public static boolean checkMode(int column,int row,char[][] board,int currentCharPos,String word,List<String> previousMoves)
    {
        char searchChar=word.charAt(currentCharPos);
        boolean isLastChar=currentCharPos==word.length()-1;

        List<String> possibleMoves=new ArrayList<> ();

        //check up
        if(column-1>=0)
        {
            if(searchChar==board[column-1][row] && !previousMoves.contains(column-1+":"+row))
            {
                 if(isLastChar)
                {
                    return true;
                }
                else{
                        possibleMoves.add(column-1+":"+row);               
                }
            }
        }
        
        //check down
        if(column+1<board.length)
        {
            if(searchChar==board[column+1][row] && !previousMoves.contains(column+1+":"+row))
            {
                if(isLastChar)
                {
                    return true;
                }
                else{

                         possibleMoves.add(column+1+":"+row);
                }
            }
        }   

        //check left
        if(row-1>=0)
        {
            if(searchChar==board[column][row-1] && !previousMoves.contains(column+":"+(row-1)))
            {
                if(isLastChar)
                {
                    return true;
                }
                else{
                        possibleMoves.add(column+":"+(row-1));        
                }
            }
        } 

        //check right
         if(row+1<board[column].length)
        {
            if(searchChar==board[column][row+1] && !previousMoves.contains(column+":"+(row+1)))
            {
                if(isLastChar)
                {
                    return true;
                }
                else{
                         possibleMoves.add(column+":"+(row+1)); 
                }
            } 
    
    }

    for (String move : possibleMoves) {
      Scanner moveScanner=new Scanner(move);
      moveScanner.useDelimiter(":");
      List<String> pList=new ArrayList<>(previousMoves);
      pList.add(move);
      if(checkMode(Integer.parseInt(moveScanner.next()), Integer.parseInt(moveScanner.next()), board, currentCharPos+1,word,pList))
      {
         moveScanner.close();
         return true;
      };
      moveScanner.close();
    }
    return false;
}
public static void main(String[] args) {
    System.out.println(exist( new char[][]{
         {'A'}
    }, "A"));
}
}
