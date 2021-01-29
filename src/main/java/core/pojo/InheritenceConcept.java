package core.pojo;

public class InheritenceConcept {

public static class A{
    public void print() {
      System.out.println("IN A Print.");
    }

    public void print1() {
      System.out.println("in A print 1.");
    }
}

public static class B extends A{
    public void print(){
      System.out.println("IN B Print.");
    }

    public void print2(){
      System.out.println("In B print2.");
    }
}

  public static void main(String[] args) {
    A a = new B();
    a.print();
    a.print1();
    //a.print2();
  }
}
