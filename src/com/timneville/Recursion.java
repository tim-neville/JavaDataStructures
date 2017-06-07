package com.timneville;

/**
 * Created by timneville on 7/6/17.
 */
public class Recursion {

    //DSA Exercise 5.7/R-5.1
    //Describe a recursive algorithm for finding the maximum element in an array, A, of n elements. What is your running time and space usage
    public int findMaxElement(int[] array, int index) {
        /*
        returns higher value of either the current index,
        or the next index (which then calls recursively until it returns the base case i.e. end of array,
        which returns the last int. The Math.max comparison then unwinds returning the higher value each time)
        */
        if (index < array.length -1) {
            return Math.max(array[index], findMaxElement(array, index +1));
        } else {
            //basecase
            return array[array.length - 1];
        }
        //Running time O(n) - algorithm checks each element in the array
    }

    //DSA Exercise 5.7/R5.8
    //Describe a recursive algorithm for converting a string of digits into the integer it represents. For example, '13531' represents the integer 13,531.
    public int convertStringToInteger(String string) {
        return Integer.parseInt(string);
    }

}
