package core.dssolutions;

import java.util.ArrayList;
import java.util.List;

public class PalindromRecursion {

    public static boolean isPalindrom(String str){
        if(str.length()<2){
            return true;
        }

        if(str.charAt(0)==str.charAt(str.length()-1)){
            return isPalindrom(str.substring(1,str.length()-1));
        }
                return false;
    }

  public static void main(String[] args) {
    //

    System.out.println(isPalindrom("aabbaa"));
      System.out.println(isPalindrom("xyzzyx"));
      System.out.println(isPalindrom("x"));
      System.out.println(isPalindrom("xx"));
      System.out.println(isPalindrom(""));
      System.out.println(isPalindrom("abaa"));

      List<Integer> list = new ArrayList<>(2);
      list.add(2);
      list.add(3);
      list.stream().mapToInt(num->num).sum();
  }
}
