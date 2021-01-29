package core.dssolutions;

import java.util.Stack;

public class StackExpressions {

  public static void main(String[] args) {

      String expression = "sau1(ra)2(n1(k3(o2(ss)p)l)d)g";
      char[] charArr = expression.toCharArray();

      Stack<String> finalStack = new Stack<>();
      Stack<Integer> numStack = new Stack<>();
      Stack<Character> bracesStack = new Stack<>();

      StringBuilder sb = new StringBuilder("");

      for(int i=0;i<charArr.length;i++){

          if('('==charArr[i]){
              bracesStack.push(charArr[i]);
              finalStack.push(sb.toString());
              sb = new StringBuilder("");

          } else if(')'==charArr[i]){
              bracesStack.pop();
              int repeat = numStack.pop();
              String str = finalStack.pop();
              String repeatStr = sb.toString();
              for(int j=0;j<repeat-1;j++){
                  sb.append(repeatStr);

              }

             sb=new StringBuilder(str+sb.toString());
          }else if(Character.isDigit(charArr[i])){
              numStack.push(Integer.parseInt(Character.toString(charArr[i])));

          }else{
              sb.append(charArr[i]);
          }
      }

      System.out.println(sb.toString());
      System.out.println(numStack.toArray().toString());
      System.out.println(finalStack.toArray().toString());
      System.out.println(bracesStack.toArray().toString());
  }
}