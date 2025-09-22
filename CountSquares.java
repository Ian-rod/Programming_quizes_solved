/*
 * You are given a stream of points consisting of x-y coordinates on a 2-D plane. Points can be added and queried as follows:

Add - new points can be added to the stream into a data structure. Duplicate points are allowed and should be treated as separate points.
Query - Given a single query point, count the number of ways to choose three additional points from the data structure such that the three points and the query point form a square. The square must have all sides parallel to the x-axis and y-axis, i.e. no diagonal squares are allowed. Recall that a square must have four equal sides.
 */


import java.util.*;
public class CountSquares {
    static ArrayList<String> cartesianPlane;
    static HashMap<String,Integer> pointFreq;
    static List<List<String>> squarePointsList;
    public CountSquares() {
        cartesianPlane=new ArrayList<>();
        pointFreq=new HashMap<>();
        squarePointsList=new ArrayList<>();
    }
    
    public void add(int[] point) {
        cartesianPlane.add(point[0]+","+point[1]);
        if(pointFreq.containsKey(point[0]+","+point[1]))
        {
            int newfreq=pointFreq.get(point[0]+","+point[1])+1;
            pointFreq.put(point[0]+","+point[1], newfreq);
        }
        else{
            pointFreq.put(point[0]+","+point[1], 1);
        }   
    }
    
    public int count(int[] point) {
        int result=0;
        String pointStr=point[0]+","+point[1];
        Scanner pointScanner;
        squarePointsList.clear();
            //Begin search
            for (String coordinate : cartesianPlane) {
                if(coordinate.equals(pointStr))
                {
                    continue;
                }

                 pointScanner=new Scanner(coordinate);
                 pointScanner.useDelimiter(",");
                 System.out.println("Coordinate is "+coordinate+" point str is "+pointStr);
                 int x=Integer.parseInt(pointScanner.next());
                 int y=Integer.parseInt(pointScanner.next());
                 int diffX=Math.abs(point[0]-x);
                 int diffY=Math.abs(point[1]-y);
                 if (diffX==diffY)
                 {
                    //check for other points
                    String pt1=String.valueOf(x)+","+point[1];
                    String pt2=String.valueOf(point[0])+","+y;
                    
                    List <String> squarePoints=List.of(pointStr,coordinate,pt1,pt2);
                    if(squarePointsList.contains(squarePoints))
                    {
                        continue;
                    }
                    else{
                        squarePointsList.add(squarePoints);
                    }
                    if(cartesianPlane.contains(pt1)&&cartesianPlane.contains(pt2))
                    {
                        //Count point duplicates
                        int duplicates=1;
                        System.out.println("Square Points "+squarePoints);
                        for (String squarepoint : squarePoints) {
                            if(pointFreq.containsKey(squarepoint))
                            {
                                if(pointFreq.get(squarepoint)>1)
                                {
                                    duplicates*=pointFreq.get(squarepoint);
                                }
                            }                     
                        }
                        System.out.println("Duplicates "+duplicates);
                        if(duplicates==0){
                           result++;
                        }
                        else{
                            result+=duplicates;
                        }
                    }
                 }
                 pointScanner.close();
            }

        return result;
    }
    public static void main(String[] args) {
        CountSquares countSquares = new CountSquares();
         countSquares.add(new int[]{5, 5});
         countSquares.add(new int[]{5, 6});
         countSquares.add(new int[]{6, 5});
        countSquares.add(new int[]{6, 6});
         System.out.println(countSquares.count(new int[]{7, 7}));
        // countSquares.add(new int[]{3, 6});
        // countSquares.add(new int[]{2, 2});
        // countSquares.add(new int[]{6, 2});
        // countSquares.add(new int[]{2, 6});
        // countSquares.add(new int[]{2, 2});// New
        //  countSquares.add(new int[]{3, 3});// New
        // countSquares.add(new int[]{6, 3});
        //  countSquares.add(new int[]{3, 6});
        System.out.println(countSquares.count(new int[]{5, 5})); //Supposed to be 8
    }
}
