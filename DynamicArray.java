/*
Design Dynamic Array (Resizable Array)
Easy
Company Tags
Design a Dynamic Array (aka a resizable array) class, such as an ArrayList in Java or a vector in C++.

Your DynamicArray class should support the following operations:

DynamicArray(int capacity) will initialize an empty array with a capacity of capacity, where capacity > 0.
int get(int i) will return the element at index i. Assume that index i is valid.
void set(int i, int n) will set the element at index i to n. Assume that index i is valid.
void pushback(int n) will push the element n to the end of the array.
int popback() will pop and return the element at the end of the array. Assume that the array is non-empty.
void resize() will double the capacity of the array.
int getSize() will return the number of elements in the array.
int getCapacity() will return the capacity of the array.
If we call pushback(int n) but the array is full, we should resize() the array first.

Example 1:

Input:
["Array", 1, "getSize", "getCapacity"]

Output:
[null, 0, 1]
Example 2:

Input:
["Array", 1, "pushback", 1, "getCapacity", "pushback", 2, "getCapacity"]

Output:
[null, null, 1, null, 2]
Example 3:

Input:
["Array", 1, "getSize", "getCapacity", "pushback", 1, "getSize", "getCapacity", "pushback", 2, "getSize", "getCapacity", "get", 1, "set", 1, 3, "get", 1, "popback", "getSize", "getCapacity"]

Output:
[null, 0, 1, null, 1, 1, null, 2, 2, 2, null, 3, 3, 1, 2]
Note:

The index i provided to get(int i) and set(int i) is guaranteed to be greater than or equal to 0 and less than the number of elements in the array.

*/

import java.util.*;

public class DynamicArray {
    List<Integer> internalList;
    int capacity=0;
    public DynamicArray(int capacity) {
        internalList=new ArrayList<>(capacity);
        this.capacity=capacity;
    }

    public int get(int i) {
        return internalList.get(i);
    }

    public void set(int i, int n) {
        internalList.set(i, n);
    }

    public void pushback(int n) {
        if(capacity==internalList.size())
        {
            resize();
        }
        internalList.addLast(n);
    }

    public int popback() {
        int lastElement=internalList.getLast();
        internalList.removeLast();
        return lastElement;
    }

    private void resize() {
        capacity=capacity*2;
    }

    public int getSize() {
        return internalList.size();
    }

    public int getCapacity() {
        return capacity;
    }
    // public static void main(String[] args) {
    //     DynamicArray arr=new DynamicArray(2);
    //     arr.pushback(0);
    //     arr.pushback(1);
    //     arr.pushback(2);
    //     System.out.println(arr.getCapacity());
    // }
}