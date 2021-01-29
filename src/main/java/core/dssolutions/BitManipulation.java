package core.dssolutions;

public class BitManipulation {

  public static void main(String[] args) {
    int n = 3;
    char[] set = {'a','b','c'};

    for (int i = 0; i < 1 << n; i++) {

        for(int j=0; j<n ; j++){
        if ((i & (1 << j)) > 0) {
            System.out.print(""+ Integer.toBinaryString(i) +"&" + Integer.toBinaryString(1<<j) + "=" +Integer.toBinaryString(i&1<<j));
            System.out.print(" index: " + j + " ,");
        }else {
            System.out.print(""+ Integer.toBinaryString(i) +"&" + Integer.toBinaryString(1<<j) + "=" +Integer.toBinaryString(i&1<<j));
            System.out.print(" index:" + "NO ,");
        }

        }
      System.out.println();
    }
  }
}
