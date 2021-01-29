package com.misc.basicproblemsolving;

public class StringPalindrome {


    public static boolean isPalindrome(String s){

        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if(s.charAt(i)!=s.charAt(len-1-i)){
                return false;
            }
        }

        String string = "";
        String str = "([A-Z]+[0-9]{2\n" ;
        String str2 = "{}";
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
    }
}
