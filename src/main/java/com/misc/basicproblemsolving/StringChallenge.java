package com.misc.basicproblemsolving;

import java.util.*;

public class StringChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = null;       //sc.next();
        String B = null;       //sc.next();
        A = "hello";
        B = "java";

        int lengthSum = A.length() + B.length();
        String[] list = {A, B};
        List<String> words = Arrays.asList(list);

        Collections.sort(words);
        System.out.println(words);

        if (words.get(0).equals(A)) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        String aCapitalize = A.substring(0, 1).toUpperCase() + A.substring(1);
        String bCapitalize = B.substring(0, 1).toUpperCase() + B.substring(1);
        System.out.println(aCapitalize + " " + bCapitalize);
    }
}
