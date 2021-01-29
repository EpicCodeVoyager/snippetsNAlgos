package core.dssolutions;

import java.util.ArrayList;

public class maximizeOnes {
    public static int onesCounter(String A){
        int counter = 0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='1'){
                counter++;
            }
        }
        return counter;
    }

    public static int flipNCount(String A,int start,int end){
        StringBuilder sb = new StringBuilder(A);

        for(int i=start;i<=end;i++){
            if(sb.charAt(i)=='1'){
                sb.setCharAt(i,'0');
            }else{
                sb.setCharAt(i,'1');
            }
        }
        return onesCounter(sb.toString());
    }

    public static ArrayList<Integer> flip(String A) {

        StringBuilder sb = new StringBuilder(A);
        ArrayList<Integer> list = new ArrayList<Integer>(2);

        int end = A.length()-1;
        int max = onesCounter(A);

        for(int i=0;i<=end;i++){
            for(int j=i;j<=end;j++){
                int temp = flipNCount(A,i,j);
                if(temp>max){
                    list.clear();
                    max = temp;
                    list.add(i+1);
                    list.add(j+1);
                }
            }
        }

        return list;
    }

  public static void main(String[] args) {

     String A = "111100000000";
    // can be solved in O(N) time.
    System.out.println(flip(A).toString());

  }

}
