/*
There are n cars traveling to the same destination on a one-lane highway.

You are given two arrays of integers position and speed, both of length n.

position[i] is the position of the ith car (in miles)
speed[i] is the speed of the ith car (in miles per hour)
The destination is at position target miles.

A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.

A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.

If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.

Return the number of different car fleets that will arrive at the destination.

Example 1:

Input: target = 10, position = [1,4], speed = [3,2]

Output: 1
Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting each other at 10, the destination.

Example 2:

Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]

Output: 3
Explanation: The cars starting at 4 and 7 become a fleet at position 10. The cars starting at 1 and 0 never catch up to the car ahead of them. Thus, there are 3 car fleets that will arrive at the destination.

Constraints:

n == position.length == speed.length.
1 <= n <= 1000
0 < target <= 1000
0 < speed[i] <= 100
0 <= position[i] < target
All the values of position are unique.

*/

import java.util.*;
public class CarFleet {
    public static  int carFleet(int target, int[] position, int[] speed) {
        //calculate using the time taken to reach the target if they reach the target 

        //sorting the positions
        List<Integer> positionList=new ArrayList<>();
        List<Integer> sortedPositionList=new ArrayList<>();
        for(int i:position)
        {
            positionList.add(i);
            sortedPositionList.add(i);
        }
        Collections.sort(sortedPositionList,Comparator.reverseOrder());

        List<Integer> speedList=new ArrayList<>(positionList.size());
        for(int i:speed)
        {
            speedList.add(i);
        }

        for(int i:sortedPositionList)
        {
            int index=positionList.indexOf(i);
            speedList.set(sortedPositionList.indexOf(i), speed[index]);

        }

        TreeSet<Double> fleets=new TreeSet<>();
        double timeToReach[]=new double[position.length];
        double lastTimeToReach=0;
        for(int i=0;i<sortedPositionList.size();i++)
        {
            //calculate the time to reach destination
            timeToReach[i]=(double)(target-sortedPositionList.get(i))/speedList.get(i);
            System.out.println(timeToReach[i]);
            if(lastTimeToReach>=timeToReach[i])
            {
                //merge this to a fleet
                timeToReach[i]=lastTimeToReach;
            }
            lastTimeToReach=timeToReach[i];
            fleets.add(timeToReach[i]);
        }
        return fleets.size();
    }
    public static void main(String[] args) {
        System.out.println(carFleet(10, new int[]{6,8},new int[]{3,2}));
    }
}
