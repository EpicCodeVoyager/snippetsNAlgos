package core.dssolutions;

public class BinaryUsingRecursion {

  public static void  printBinary(int n){
    System.out.println("printBinary (" + n +")");
      if(n<2) {
        System.out.print(n);
      } else {

      int lastDigit = n % 2;
      int remainingDigit = n / 2;

      printBinary(remainingDigit);
      System.out.print(lastDigit);
      }
  }

  public static void main(String[] args) {
    printBinary(4);
    printBinary(5);
    printBinary(7);
  }

}
