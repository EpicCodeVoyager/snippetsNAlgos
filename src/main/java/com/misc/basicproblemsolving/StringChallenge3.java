package com.misc.basicproblemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringChallenge3 {
    //String  has the following lexicographically-ordered substrings of length :

    public static void main(String[] args) {
        String s = "welcometojava";
        int sLength = s.length();

        int k=3;

        String[] list = new String[100];
        int nextAddIndex = 0;

        // Using comparator and lists :
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < sLength; i++) {
            if (i + 2 < sLength) {
                lists.add("" + s.charAt(i) + s.charAt(i + 1) + s.charAt(i + 2));
            }
        }
        Collections.sort(lists, Collections.reverseOrder());
        // System.out.printf(lists.toString());
        // Without using comparator and lists:

        for (int i = 0; i < sLength; i++) {
            if (i + k -1 < sLength) {
                list[nextAddIndex] = ("" + s.charAt(i) + s.charAt(i + 1) + s.charAt(i + 2));
                nextAddIndex += 1;
            }
        }

        for (int i = 0; i < nextAddIndex; i++) {
            for (int j = i+1; j < nextAddIndex; j++) {
                if(list[i].compareTo(list[j])>0) {
                    //swap
                    String temp = list[i];
                    list[i]=list[j];
                    list[j]=temp;
                }
            }
        }

        System.out.println(list[0]);
        System.out.println(list[nextAddIndex-1]);

//        for (int i = 0; i < nextAddIndex ; i++) {
//            System.out.println(list[i]);
//        }

        System.out.println();

    }
}