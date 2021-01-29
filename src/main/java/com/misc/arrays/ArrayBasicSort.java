package com.misc.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayBasicSort {

    public static void main(String[] args) {
        // Here will be dealing with the basic sorting of and array.
        // Initializing the array in different manner.
        // Accessing the array via different for loop mechanisms.


        int[] intArr = {1,2,3,4,5,6,88,90};
        Integer[] intArrIntType = {4,5,6,78,9};
        ArrayList<Integer> arrayListInt = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(4);
            }
        };

        List<Integer> arrayListInt2 = Arrays.asList(intArrIntType);

    }
}
